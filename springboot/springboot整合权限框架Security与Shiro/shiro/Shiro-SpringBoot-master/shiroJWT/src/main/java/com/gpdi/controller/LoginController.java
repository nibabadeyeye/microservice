package com.gpdi.controller;

import com.gpdi.mapper.UserMapper;
import com.gpdi.util.ResultMap;
import com.gpdi.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-04-29
 * @Time 13:20
 */
@RestController
public class LoginController {
    private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public LoginController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }

    /**
     * @desc;调用系统登录的方法
     *
     *               1、判断系统的用户名是否存在
     *
     *               2、判断系统的用户密码是否存在
     *
     *               3、如果用户名和密码都正确，则生成Token信息并返回
     */
    @PostMapping("/login")
    public ResultMap login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {

        String realPassword ="";
        if(username.equals("root")){
            realPassword = "123456";
        }
             //判断系统用户名是否存在，如果存在继续判断用户密码是否为空
        if (realPassword == null) {
            return resultMap.fail().code(401).message("用户名错误");
            //判断系统用户密码是否准确
        } else if (!realPassword.equals(password)) {
            return resultMap.fail().code(401).message("密码错误");
        } else {
            return resultMap.success().code(200).message(JWTUtil.createToken(username));
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }
}
