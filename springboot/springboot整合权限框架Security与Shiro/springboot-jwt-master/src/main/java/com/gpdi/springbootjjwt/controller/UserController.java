package com.gpdi.springbootjjwt.controller;
import com.alibaba.fastjson.JSONObject;
import com.gpdi.springbootjjwt.annotation.UserLoginToken;
import com.gpdi.springbootjjwt.entity.User;
import com.gpdi.springbootjjwt.service.TokenService;
import com.gpdi.springbootjjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @UserLoginToken
    @RequestMapping("/test")
    public String test(){
        return "testDemo";
    }
    @RequestMapping("/login")
    public Object login( ){
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123456");
        JSONObject jsonObject=new JSONObject();
        User myuser=userService.findByUsername(user);
        if(myuser==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!myuser.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                //创建一个Token,包含用户信息
                String token = tokenService.getToken(myuser);
                jsonObject.put("token", token);
                jsonObject.put("user", myuser);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @RequestMapping("/getMessage")
    public String getMessage()
    {
        return "你已通过验证";
    }
}
