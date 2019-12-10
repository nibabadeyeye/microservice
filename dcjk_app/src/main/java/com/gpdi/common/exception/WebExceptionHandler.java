package com.gpdi.common.exception;

import com.gpdi.common.respone.ActionResult;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class WebExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(WebException.class)
    public ActionResult handleRRException(WebException e) {
        ActionResult result = new ActionResult();
        result.setCode(e.getCode());
        result.setMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ActionResult handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return ActionResult.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public ActionResult handleAuthorizationException(AuthorizationException e) {
        logger.error(e.getMessage(), e);
        return ActionResult.error("您没有访问权限");
    }

    @ExceptionHandler(Exception.class)
    public ActionResult handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return ActionResult.error("未知异常信息");
    }
}
