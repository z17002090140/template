package com.example.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException{
    int errorCode;
    String msg;

    public CustomException(int errorCode,String msg){
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public CustomException(ResponseCode code){
        this.errorCode = code.getErrorCode();
        this.msg = code.getMsg();
    }
}
