package com.gpdi.controller;

import com.gpdi.service.UserServiceImpl;
import com.gpdi.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {


    /**
     * @param user User
     * @return 如果保存成功的话，返回{@link User},否则返回<code>null</code>
     */
    @PostMapping("/user/addUser")
    public void saveUser(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * @return 所有的用户数据
     */
    @GetMapping("/user/list")
    public List<User> list() {
        return userService.getAllUser();
    }

    @Autowired
    private UserServiceImpl userService;
}
