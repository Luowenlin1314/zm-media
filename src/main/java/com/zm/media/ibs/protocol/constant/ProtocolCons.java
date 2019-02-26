package com.zm.media.ibs.protocol.constant;

/**
 * Created by USERA on 2019/2/14.
 * 协议名称
 */
public interface ProtocolCons {

    /********心跳************/
    Integer TERMINAL_HEARTBEAT = 100;

    /********终端相关************/
    //终端身份校验
    Integer TERMINAL_IDENTITY = 1001;
    //终端身份成功
    Integer TERMINAL_IDENTITY_FAIL = 10010;
    //终端身份失败
    Integer TERMINAL_IDENTITY_SUCCESS = 10011;

    /********节目相关************/
    Integer PROGRAM_UPDATE = 2001;
}
