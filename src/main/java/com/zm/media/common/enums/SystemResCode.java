package com.zm.media.common.enums;

/**
 * 全局返回码
 */

public enum SystemResCode {
    STATUS_SUCCESS(1, "操作成功"),
    STATUS_FAILED(-1, "操作失败"),
    STATUS_WARNING(-2, "发生异常"),
    PLATFORM_INVOKE(-3, "平台调用异常"),
    PARAMETER_NULL(-4, "所需参数为空");

    private Integer code;
    private String msg;

    SystemResCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
