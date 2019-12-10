package com.gpdi.shiro.exception;

import com.gpdi.shiro.util.ResponseData;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * @Auther: Kevin Cui
 * @Date: 18/7/2 14:45
 * @Description:异常处理器
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {


    /**
     * @desc: 没有权限 403
     */
    @ExceptionHandler(AuthorizationException.class)
    public ResponseData handle0(AuthorizationException exception) {
        logger.info(exception.getMessage());
        return new ResponseData(403, "没有权限");
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());

}
