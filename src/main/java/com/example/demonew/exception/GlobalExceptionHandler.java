package com.example.demonew.exception;


import com.example.demonew.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice//等于Controlleradvice+responsebody，responsebody会把方法的返回值转换为json
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败");
    }

}
