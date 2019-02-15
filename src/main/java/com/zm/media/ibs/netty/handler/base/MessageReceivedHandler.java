package com.zm.media.ibs.netty.handler.base;

import com.zm.media.ibs.netty.handler.container.TerminalContainer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by USERA on 2019/2/12.
 * 消息接收
 */
@Component
@ChannelHandler.Sharable
public class MessageReceivedHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MessageDispatchHandler messageDispatchHandler;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        Long deviceId = TerminalContainer.getTerminalDeviceId(ctx);
        TerminalContainer.removeTerminal(deviceId);
        logger.info("终端退出：" + deviceId + "，当前在线终端数量：" + TerminalContainer.getTerminalSize());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String data = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
            logger.info("收到终端" + ctx.channel().remoteAddress() + "的消息：" + data);

            //消息处理
            messageDispatchHandler.messageReceive(ctx,data);
        } finally {
            /**
             * ByteBuf是一个引用计数对象，这个对象必须显示地调用release()方法来释放。
             * 请记住处理器的职责是释放所有传递到处理器的引用计数对象。
             */
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }



}
