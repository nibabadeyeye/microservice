package com.gpdi.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
@RestController
@RequestMapping(value="test")
public class TestController {
    private volatile  String name;
    @RequestMapping(value ="test")
    public String test(String username){
        System.out.println("调用了Controller方法");
        String newName="my name is  "+username;
        return newName;
    }
}
