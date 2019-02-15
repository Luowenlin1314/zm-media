package com.zm.media.ibs.netty.handler.base;

import com.zm.media.ibs.protocol.base.BasePro;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by USERA on 2019/2/14.
 */
public abstract class BaseHandler {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public abstract void handler(ChannelHandlerContext ctx, BasePro basePro);
}
