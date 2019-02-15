package com.zm.media.ibs.netty.handler.transfer;

import com.zm.media.ibs.netty.handler.container.TerminalContainer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by USERA on 2019/2/15.
 * 消息转发
 */
@Component
public class TransferHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 通过设备id发送数据
     * @param deviceId
     * @param msg
     */
    public void sendMessage(Long deviceId, String msg){
        ChannelHandlerContext ctx = TerminalContainer.getTerminal(deviceId);
        ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
        ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        logger.info("向终端" + deviceId +"发送数据：" + msg);
    }

}
