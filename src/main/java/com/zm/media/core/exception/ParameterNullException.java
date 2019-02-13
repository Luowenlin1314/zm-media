package com.zm.media.core.exception;

/**
 * 参数为空异常
 */

public class ParameterNullException extends RuntimeException {
    private String message;

    private Integer code;

    public ParameterNullException() {
    }

    public ParameterNullException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
