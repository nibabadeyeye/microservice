package com.gpdi.user.controller;

import com.gpdi.user.entity.User;
import com.gpdi.user.hystrix.UserServiceFallBack;
import com.gpdi.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserService {

    @Override
    public boolean saveUser(User user) {
        return userService.saveUser(user);
    }

   // @HystrixCommand(fallbackMethod = "getAllUserFall")
    @Override
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    public List<User> getAllUserFall() {
        System.out.println("查询用户熔断");
        return null;
    }

    private final UserService userService;

    @Autowired
    public UserController(UserService personService) {
        this.userService = personService;
    }
}
