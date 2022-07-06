package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicateException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.yaml.snakeyaml.serializer.SerializerException;

/*控制类的基类*/
public class BaseController {
    /*操作成功的状态码*/
    public static final int OK = 200;
    /*ExceptionHandler用于统一处理方法抛出的异常*/
    @ExceptionHandler(SerializerException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if(e instanceof UsernameDuplicateException){
            result.setState(4000);
        }else if(e instanceof InsertException){
            result.setState(5000);
        }
        return result;
    }
}
