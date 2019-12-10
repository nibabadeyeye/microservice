package com.gpdi.config.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @description: 这是类是一个切面（与之相关的是切点、切点表达式、通知类型）
 *
 */
@Aspect
@Component
public class SystemLog {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 直接把切点设置到controller包级别
     */
//    @Pointcut("within(com.gpdi.controller.*)")
//    public void pointCut() {
//
//    }
    /**
    * 将切点设置为某个类级别
    */
    @Pointcut("execution(* com.gpdi.web.*.*(..))")
    public void pointCut() {

    }
    /**
     * 利用Aspect进行日志的设置
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();//获取request
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();//获取response
       // String username = request.getParameter("username");
       // String token = request.getHeader("token");
        //判断用户名是否为空
//        if (username == null || "" == username) {
//            //将Token信息进行解析
//            String sql = "select username from sys_user where id=(select user_id from sys_user_token where token='" + token + "')";
//            username = jdbcTemplate.queryForObject(sql, String.class);
//
//        }

        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        //  saveSysLog(point, time, username);
        return result;
    }

//    private void saveSysLog(ProceedingJoinPoint joinPoint, long time, String username) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        SysLog sysLog = new SysLog();
//        SystemLog log = method.getAnnotation(SystemLog.class);
//        if (log != null) {
//            //获取注解描述
//            sysLog.setOperation(log.value());
//        }
//        //  joinPoint.getTarget().
//
//        //请求的方法名
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = signature.getName();
//        sysLog.setMethod(className + "." + methodName + "()");
//        sysLog.setUsername(username);
//        // 获取所有参数
//        Object[] args = joinPoint.getArgs();
//        try {
//            String params = JSONObject.toJSONString(args);
//            sysLog.setParams(params);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
//        if (servletRequestAttributes != null) {
//            HttpServletRequest request = servletRequestAttributes.getRequest();
//            //设置IP地址
//            sysLog.setIp(request.getRemoteAddr());
//        }
//        //TODO 获取执行的sql语句
//        sysLog.setExecuteSql(null);
//        //用户名
//        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
//        if (username == null && sysUser != null) {
//            username = sysUser.getUsername();
//            sysLog.setUsername(username);
//        }
//        sysLog.setTime(time);
//        sysLog.setCreateDate(new Date());
//        //保存系统日志
//        sysLogService.saveSysLog(sysLog);
//    }

}
