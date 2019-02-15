package com.zm.media.ibs.netty.handler.container;

import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by USERA on 2019/2/12.
 */
public class TerminalContainer {

    /**
     * 存放终端
     *
     */
    private static ConcurrentHashMap<Long, ChannelHandlerContext> terminals = new ConcurrentHashMap<>();

    /**
     * 获取当前终端数据
     * @return
     */
    public static Integer getTerminalSize(){
        return terminals.size();
    }

    /**
     * 添加终端
     * @param deviceId
     * @param ctx
     */
    public static void addTerminal(Long deviceId,ChannelHandlerContext ctx){
        if(!terminals.containsKey(deviceId)){
            terminals.put(deviceId,ctx);
        }
    }

    /**
     * 移除终端
     * @param deviceId
     */
    public static void removeTerminal(Long deviceId){
        terminals.remove(deviceId);
    }

    /**
     * 根据ctx获取设备id
     * @param ctx
     */
    public static Long getTerminalDeviceId(ChannelHandlerContext ctx){
        Long deviceId = null;
        Iterator<Map.Entry<Long, ChannelHandlerContext>> it = terminals.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, ChannelHandlerContext> entry = it.next();
            if (entry.getValue().equals(ctx)) {
                deviceId = entry.getKey();
            }
        }
        return deviceId;
    }

    /**
     * 根据deviceId获取终端
     * @param deviceId
     * @return
     */
    public static ChannelHandlerContext getTerminal(Long deviceId){
        return terminals.get(deviceId);
    }


}
