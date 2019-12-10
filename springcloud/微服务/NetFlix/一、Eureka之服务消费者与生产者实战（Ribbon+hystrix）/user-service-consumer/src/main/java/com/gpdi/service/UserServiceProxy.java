package com.gpdi.service;//package com.gpdi.service;


import com.gpdi.user.entity.User;
import com.gpdi.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:UserServiceProxy 实现
 *
 */
@Service
public class UserServiceProxy implements UserService {

    private static final String PROVIDER_SERVER_URL_PREFIX = "http://user-service-provider";

    /**
     * 通过 REST API 代理到服务器提供者
     */
    @Autowired
    private RestTemplate restTemplate;



    @Override
    public void addUser(User user) {
        restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save", user, User.class);
    }

    @HystrixCommand(fallbackMethod = "getAllFallBack")
    @Override
    public List<User> getAllUser() {
        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", List.class);
    }

    @ResponseBody
    public List<User> getAllFallBack(){
        List<User>list=new ArrayList<User>();
        User user=new User();
        user.setName("session");
        user.setId(1L);
        list.add(user);
        return   list;
    }
}
