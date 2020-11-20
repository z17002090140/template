package com.example.demo.response;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    /**
     * 自定义的异常处理类
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServerResponse<?> exceptionHandler(Exception e){
        if(e instanceof CustomException){
            CustomException ce = (CustomException)e;
            return ServerResponse.ErrorCode(ce.getErrorCode(),ce.getMsg());
        }
        System.out.println(e);
        return ServerResponse.ErrorCode(ResponseCode.SERVER_ERROR);
    }
}
