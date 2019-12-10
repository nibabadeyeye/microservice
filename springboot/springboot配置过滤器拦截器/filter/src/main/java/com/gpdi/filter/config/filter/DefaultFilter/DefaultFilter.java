package com.gpdi.filter.config.filter.DefaultFilter;
import javax.servlet.*;
import org.springframework.stereotype.Component;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
@Component
@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"})
public class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Tomcat容器启动会初始化默认过滤器，这个方法是单例的，整个过程只执行一次");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        System.out.println("执行默认的过滤器");
//        System.out.println("对请求进行过滤，针对所有的请求");
//        System.out.println("主要用于 权限判断，控制转向、业务逻辑");
//        System.out.println(request.getHeader("username"));
//        System.out.println( "获取属性名称 "+ request.getParameter("username"));
//        System.out.println( "获取属性名称 "+servletRequest.getParameter("username"));
//        if (request.getParameter("username").equals("whss"))  {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            response.setHeader("Content-type", "application/json;charset=UTF-8");
//            response.getWriter().write(JSONObject.toJSON(new ResponseData(403, "您还未登录")).toString());
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("容器关闭后关闭");
    }
}
