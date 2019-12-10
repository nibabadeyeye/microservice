package com.gpdi.filter;

import com.alibaba.fastjson.JSONObject;
import com.gpdi.util.ResponseData;
import com.gpdi.web.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Auther: Kevin Cui
 * @Date: 2018/11/13 10
 * @Description: 过滤器，对所有的请求进行拦截
 */
@Component
@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionManager sessionManager;

    @Value("${not-need-filter-session-urls}")
    private String notNeedFilterSessionUrls;

    @Value("${filter-enable}")
    private boolean filterEnable;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        logger.info("Request Uri: " + uri);
        ServletContext context=webApplicationContext.getServletContext();
        if(context.getAttribute("whs")==null){
            context.setAttribute("whs","王华森");
        }else{

        }

        //Token 信息（X-iEnvPro-Token）
        logger.info("Request Token: " + request.getHeader("X-iEnvPro-Token"));
        String token = request.getHeader("X-iEnvPro-Token");

        if (filterEnable && !isNotNeedFilter(uri)) {
            User user = null;
            if (token != null) {
                user = (User) request.getServletContext().getAttribute(token);
                logger.info("User ID: " + (user != null ? user.getUid() : "null"));
            }
            if (user == null) {
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                response.getWriter().write(JSONObject.toJSON(new ResponseData(100, "您还未登录")).toString());
            } else {
                request.setAttribute("user", user);
                filterChain.doFilter(request, response);
            }
        } else {
            if (token != null) {
                request.setAttribute("user", request.getServletContext().getAttribute(token));
            }
            filterChain.doFilter(request, response);
        }
    }

    private boolean isNotNeedFilter(String url) {
        String[] urls = notNeedFilterSessionUrls.split(",");
        for (String u : urls) {
            if (url.startsWith(u)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
