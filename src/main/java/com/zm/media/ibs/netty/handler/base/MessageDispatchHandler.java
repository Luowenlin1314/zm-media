package com.zm.media.ibs.netty.handler.base;

import com.zm.media.common.util.JacksonUtils;
import com.zm.media.ibs.netty.handler.TerminalIdentityHandler;
import com.zm.media.ibs.protocol.base.BasePro;
import com.zm.media.ibs.protocol.constant.ProtocolCons;
import com.zm.media.ibs.protocol.terminal.IdentityPro;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by USERA on 2019/2/14.
 */
@Component
public class MessageDispatchHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TerminalIdentityHandler terminalIdentityHandler;


    /**
     * 消息接收
     * @param ctx
     * @param msg
     */
    public void messageReceive(ChannelHandlerContext ctx, String msg){
        try{
            BasePro basePro = JacksonUtils.json2Pojo(msg, BasePro.class);
            Integer name = basePro.getName();

            //终端身份校验
            if(name.equals(ProtocolCons.TERMINAL_IDENTITY)){
                terminalIdentityHandler.handler(ctx,basePro);
            }else if(name.equals(ProtocolCons.TERMINAL_HEARTBEAT)){
                logger.error("心跳：" + ctx.channel().remoteAddress());
            }
            else{
                logger.error("未知协议：" + msg);
            }
        }catch (Exception e){
            logger.error("消息转换异常：" + msg);
            ctx.channel().close();
        }
    }

    public static void main(String[] args) {
        String json = "{\"data\":{\"deviceCode\":\"632d9147-34ec-419a-9ede-ed112481dd7e\",\"netIP\":\"test\",\"netMac\":\"test\",\"netType\":1,\"resolution\":\"test\",\"version\":\"6.0.1\"},\"name\":1001}";
        BasePro basePro = JacksonUtils.json2Pojo(json, BasePro.class);
        System.out.println(basePro.getName());
    }

}
