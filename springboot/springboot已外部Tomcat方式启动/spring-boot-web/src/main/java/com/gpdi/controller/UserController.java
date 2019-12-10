package com.gpdi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @GetMapping("getUser")
    public String getUser(){
        return "{id:1,name:张三}";
    }
}
