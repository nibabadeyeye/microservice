package com.gpdi.user.controller;

import com.gpdi.user.entity.User;
import com.gpdi.user.service.UserService;
import com.gpdi.user.service.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @PostMapping(value = "savaUser")
    public boolean saveUser(User user) {
        return userServiceProxy.saveUser(user);
    }

    @GetMapping(value = "user/getAllUser")
    public List<User> getAllUser() {
        return userServiceProxy.getAllUser();
    }

    @Autowired
    private UserServiceProxy userServiceProxy;
}
