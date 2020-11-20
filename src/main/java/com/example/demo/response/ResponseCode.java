package com.example.demo.response;

public enum ResponseCode {
    /**
     * 系统错误
     */
    SERVER_ERROR(-1,"系统错误"),
    MISSING_PARAMETERS(-2,"缺少参数"),
    ILLEGAL_REQUEST(400, "不合法的请求"),
    /**
     * 成功的请求
     */
    SUCCESS(200,"成功"),
    ERROR(201,"失败")
    ;

    private final int errorCode;
    private final String msg;

    ResponseCode(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode(){
        return errorCode;
    }

    public String getMsg(){
        return msg;
    }
}
