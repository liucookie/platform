package com.hangyu.platform.global;

/**
 * 自定义异常类
 */
public class PlatException extends RuntimeException {

    private int code;
    private String message;


    public PlatException(String message) {
        this.message = message;
    }
    public PlatException(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.getCode();
        this.message = resultStatusEnum.getMessage();
    }


    public PlatException(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
