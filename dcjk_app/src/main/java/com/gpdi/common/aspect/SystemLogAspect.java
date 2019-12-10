//package com.gpdi.common.aspect;
//
//import com.alibaba.fastjson.JSONObject;
//import com.gpdi.common.annotation.SystemLog;
//import org.apache.shiro.SecurityUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.Date;
//
//
///***
// * @Author Zhb
// * @Description 系统日志 aop
// * @Date 2019/6/28 11:30
// **/
//@Aspect
//@Component
//public class SystemLogAspect {
//
//    @Autowired
//    private SysLogService sysLogService;
//
//    @Pointcut("@annotation(com.gpdi.common.annotation.SystemLog)")
//    public void pointCut() {
//
//    }
//
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        long beginTime = System.currentTimeMillis();
//        //执行方法
//        Object result = point.proceed();
//        //执行时长(毫秒)
//        long time = System.currentTimeMillis() - beginTime;
//        //保存日志
//        saveSysLog(point, time);
//        return result;
//    }
//
//    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        SysLog sysLog = new SysLog();
//        SystemLog log = method.getAnnotation(SystemLog.class);
//        if (log != null) {
//            //获取注解描述
//            sysLog.setOperation(log.value());
//        }
//        //请求的方法名
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = signature.getName();
//        sysLog.setMethod(className + "." + methodName + "()");
//        // 获取所有参数
//        Object[] args = joinPoint.getArgs();
//        try {
//            String params = JSONObject.toJSONString(args);
//            sysLog.setParams(params);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
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
//        if (sysUser != null) {
//            String username = sysUser.getUsername();
//            sysLog.setUsername(username);
//        }
//        sysLog.setTime(time);
//        sysLog.setCreateDate(new Date());
//        //保存系统日志
//        sysLogService.saveSysLog(sysLog);
//    }
//
//}
