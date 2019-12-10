package com.gpdi.shiro.web.user.controller;

import com.gpdi.shiro.util.ResponseData;
import com.gpdi.shiro.web.user.entity.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequiresPermissions("user:getAllUser1")
    @RequestMapping("getAllUser")
    public ResponseData getAllUser(){
        List<User>list=new ArrayList<>();
        list.add(new User(1,"admin"));
        list.add(new User(2,"root"));
        return new ResponseData(200,list,"获取用户数据成功");
    }

}
