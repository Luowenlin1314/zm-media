package com.zm.media.spring.config;

import com.zm.media.ibs.netty.handler.base.HeartbeatHandler;
import com.zm.media.ibs.netty.handler.base.MessageReceivedHandler;
import com.zm.media.spring.data.NettyProps;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by USERA on 2019/2/12.
 * netty 相关配置处理
 */
@Configuration
public class NettyConfig {

    @Autowired
    private NettyProps nettyProps;
    @Autowired
    private MessageReceivedHandler messageReceivedHandler;
    @Autowired
    private HeartbeatHandler heartbeatHandler;

    @Bean
    public Integer nettyPort(){
        return nettyProps.getPort();
    }

    @Bean
    public ChannelFuture nettyStart() throws InterruptedException {
        //Netty内部都是通过线程在处理各种数据，EventLoopGroup就是用来管理调度他们的，注册Channel，管理他们的生命周期。
        //NioEventLoopGroup是一个处理I/O操作的多线程事件循环
        //bossGroup作为boss,接收传入连接,仅接收客户端连接，不做复杂的逻辑处理，为了尽可能减少资源的占用，取值越小越好
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //workerGroup作为worker，处理boss接收的连接的流量和将接收的连接注册进入这个worker
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //ServerBootstrap负责建立服务端
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                //指定使用NioServerSocketChannel产生一个Channel用来接收连接
                .channel(NioServerSocketChannel.class)
                //ChannelPipeline用于存放管理ChannelHandel
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    public void initChannel(SocketChannel ch) throws Exception {
                        //心跳处理
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new IdleStateHandler(nettyProps.getReadIdleTime(),
                                nettyProps.getWriteIdleTime(), nettyProps.getAllIdleTime(), TimeUnit.SECONDS));
                        pipeline.addLast(heartbeatHandler);

                        //ChannelPipeline用于存放管理ChannelHandel
                        //ChannelHandler用于处理请求响应的业务逻辑相关代码
                        pipeline.addLast(messageReceivedHandler);
                    }
                })
                //BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，
                //用于临时存放已完成三次握手的请求的队列的最大长度。如果未设置或所设置的值小于1，Java将使用默认值50。
                //Option是为了NioServerSocketChannel设置的，用来接收传入连接的
                .option(ChannelOption.SO_BACKLOG, 128)
                //是否启用心跳保活机制。在双方TCP套接字建立连接后（即都进入ESTABLISHED状态）并且在两个小时左右上层没有任何数据传输的情况下，这套机制才会被激活。
                //childOption是用来给父级ServerChannel之下的Channels设置参数的
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        ChannelFuture channelFuture = serverBootstrap.bind(nettyPort()).sync();
        return channelFuture;
    }

}
