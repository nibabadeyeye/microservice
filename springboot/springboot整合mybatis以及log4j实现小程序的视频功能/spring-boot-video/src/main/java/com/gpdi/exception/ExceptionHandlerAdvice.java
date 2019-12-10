package com.gpdi.exception;
import com.gpdi.util.ResponseData;
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
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 参数校验错误处理
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseData handle(BindException exception) {
        //获取参数校验错误集合
        List<FieldError> fieldErrors = exception.getFieldErrors();
        Map<String, Object> data = new HashMap(20);
        //格式化以提供友好的错误提示
        for (FieldError error : fieldErrors) {
            data.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseData(400, "参数校验错误", data);
    }
     //参数校验错误
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseData handle(ConstraintViolationException exception) {
        List<String> messages = new ArrayList<>();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            messages.add(violation.getMessage());
        }
        return new ResponseData(400, "参数校验错误", messages);
    }
    //空指针异常
    @ExceptionHandler(Exception.class)
    public ResponseData handle(Exception exception) {
        exception.printStackTrace();
        return new ResponseData(500, "Internal Server Error");
    }


}
