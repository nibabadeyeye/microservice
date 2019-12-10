package com.gpdi.filter;

import com.gpdi.web.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @Auther: Kevin Cui
 * @Date: 2018/11/13 09
 * @Description:
 */
@Component
public class SessionManager {
    @Autowired
    private WebApplicationContext webApplicationContext;

    public User getUser(String token) {
        ServletContext servletContext = webApplicationContext.getServletContext();
        User user = (User) servletContext.getAttribute(token);
//        if ("test".equals(token)) {
//            user = new User();
//            user.setId("test");
//            user.setNickName("test");
//        }
        return user;
    }
}
