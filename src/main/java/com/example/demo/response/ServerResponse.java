package com.example.demo.response;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class ServerResponse<T> implements Serializable {
    private int errorCode;

    private String msg;

    private String serverTime;

    private T data;

    public ServerResponse(int errorCode, String msg, T data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.serverTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.data = data;
    }

    public ServerResponse(int errorCode,String msg){
        this(errorCode,msg,null);
    }

    /**
     * 默认的成功
     */
    public static <T> ServerResponse<T>SuccessDefault(){
        return new ServerResponse(ResponseCode.SUCCESS.getErrorCode(),ResponseCode.SUCCESS.getMsg());
    }

    /**
     * 带数据的成功
     */
    public static <T> ServerResponse<T>SuccessListDefault(T data){
        return new ServerResponse(ResponseCode.SUCCESS.getErrorCode(),ResponseCode.SUCCESS.getMsg(),data);
    }
    /**
     * 默认的失败
     */
    public static <T>ServerResponse<T>ErrorDefault(){
        return new ServerResponse(ResponseCode.ERROR.getErrorCode(),ResponseCode.ERROR.getMsg());
    }

    /**
     * 自定义的失败
     */
    public static <T>ServerResponse<T>ErrorCode(int errorCode,String msg){
        return new ServerResponse(errorCode,msg);
    }

    public static <T>ServerResponse<T>ErrorCode(ResponseCode code){
        return new ServerResponse(code.getErrorCode(),code.getMsg());
    }
}
