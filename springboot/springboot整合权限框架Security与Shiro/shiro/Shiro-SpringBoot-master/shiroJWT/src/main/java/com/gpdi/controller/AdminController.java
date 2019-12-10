package com.gpdi.controller;

import com.gpdi.mapper.UserMapper;
import com.gpdi.util.ResultMap;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 *
 * @Description admin角色权限controller
 *
 * @Date 2018-04-29
 *
 * @Time 17:32
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public AdminController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }

    @GetMapping("/getUser")
  //  @RequiresRoles("admin")
    public ResultMap getUser() {
        String []arr={"root","test"};
        List<String> list =  Arrays.asList(arr);
        //List<String> list = userMapper.getUser();
        return resultMap.success().code(200).message(list);
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
   // @RequiresRoles("admin")
    public ResultMap updatePassword(String username) {
        userMapper.banUser(username);
        return resultMap.success().code(200).message("成功封号！");
    }


    private final UserMapper userMapper;
    private final ResultMap resultMap;
}
