package com.whs.controller;
import com.whs.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StringController {
    @Autowired
    StringService userService;
    //查询
    @RequestMapping("/queryOne")
    public String quertOne(String key)
    {
        return userService.queryOne(key);
    }
    //增加
    @RequestMapping("/add")
    public void add(String key,String value)
    {
         userService.addUser(key,value);
    }
    //增加
    @RequestMapping("/update")
    public void update(String key,String value)
    {
        userService.updateUser(key,value);
    }
    //增加
    @RequestMapping("/delete")
    public void delete(String key,String value)
    {
        userService.deleteUser(key);
    }

}
