package com.gpdi.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
@RestController
@RequestMapping(value="user")
public class UserController {
    @RequestMapping(value ="test")
    public String test(String username){
        String newName="my name is  "+username;
        return newName;
    }
}
