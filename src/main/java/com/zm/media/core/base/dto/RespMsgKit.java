package com.zm.media.core.base.dto;


import com.zm.media.common.enums.SystemResCode;

/**
 * 构建返回到客户端的消息工具类
 */
public class RespMsgKit {

    public static RespMsg buildSuccessRespMsg(String msg) {
        if (msg == null) {
            msg = "操作成功!";
        }
        return new RespMsg(SystemResCode.STATUS_SUCCESS.getCode(), msg);
    }

    public static RespMsg buildSuccessRespMsg() {
        return new RespMsg(SystemResCode.STATUS_SUCCESS.getCode(), SystemResCode.STATUS_SUCCESS.getMsg());
    }

    public static RespMsg buildSuccessRespMsg(Object object) {
        return new RespMsg(SystemResCode.STATUS_SUCCESS.getCode(), SystemResCode.STATUS_SUCCESS.getMsg(), object);
    }

    public static RespMsg buildFailedRespMsg(String msg) {
        if (msg == null) {
            msg = "操作失败!";
        }
        return new RespMsg(SystemResCode.STATUS_FAILED.getCode(), msg);
    }

    public static RespMsg buildFailedRespMsg() {
        return new RespMsg(SystemResCode.STATUS_FAILED.getCode(), SystemResCode.STATUS_FAILED.getMsg());
    }

    public static RespMsg buildFailedRespMsg(Object object) {
        return new RespMsg(SystemResCode.STATUS_FAILED.getCode(), SystemResCode.STATUS_FAILED.getMsg(), object);
    }

    public static RespMsg buildRespMsg(Integer status, String msg) {
        return new RespMsg(status, msg);
    }

    public static RespMsg buildWarningRespMsg(String msg) {
        if (msg == null) {
            msg = "发生异常!";
        }
        return new RespMsg(SystemResCode.STATUS_WARNING.getCode(), msg);
    }

    public static RespMsg buildWarningRespMsg() {
        return new RespMsg(SystemResCode.STATUS_WARNING.getCode(), SystemResCode.STATUS_WARNING.getMsg());
    }
}
