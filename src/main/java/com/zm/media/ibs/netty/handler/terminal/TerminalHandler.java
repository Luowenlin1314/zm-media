package com.zm.media.ibs.netty.handler.terminal;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by USERA on 2019/2/12.
 */
public class TerminalHandler {

    /**
     * 存放终端
     *
     */
    private static Map<String, ChannelHandlerContext> terminals = new ConcurrentHashMap<>();



}
