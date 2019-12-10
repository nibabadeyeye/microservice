package com.gpdi.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController(value = "testController")
public class LoginController {
    @GetMapping("login")
    public ResponseData login(String username,String password){
        return new ResponseData().setCode(200).setMessage("登录成功").setResponseData(new ArrayList<>());
    }
}
