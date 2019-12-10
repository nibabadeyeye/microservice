package com.gpdi.filter.config.filter.MyFilter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Description 自定义过滤器
 * @Author Mr whs
 * @Date date
 */
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("Tomcat容器启动会初始化自定义过滤器，这个方法是单例的，整个过程只执行一次");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行自定义的过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
