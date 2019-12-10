package com.gpdi.filter.config.interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Description 自定义拦截器
 * @Author Mr whs
 * @Date date
 */
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
    //调用Controller里的方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行过拦截器前");
//        response.setHeader("Content-type", "application/json;charset=UTF-8");
//        response.getWriter().write(JSONObject.toJSON(new ResponseData(403, "您还未登录")).toString());
        return true;
    }

    //调用Controller里面的方法后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器调用Controller后");
    }

    //页面渲染后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行拦截器后");
    }
}
