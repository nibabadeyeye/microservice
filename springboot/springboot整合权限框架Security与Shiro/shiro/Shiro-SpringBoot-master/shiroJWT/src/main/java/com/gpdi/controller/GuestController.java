package com.gpdi.controller;

import com.gpdi.util.ResultMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 游客角色可以访问的页面
 * @Date 2018-04-30
 * @Time 14:24
 */
@RestController
@RequestMapping("/guest")
public class GuestController {


//    @Autowired
//    public GuestController(ResultMap resultMap) {
//        new ResultMap() = resultMap;
//    }

    @GetMapping("/welcome")
    public ResultMap login() {
        return new ResultMap().success().code(200).message("欢迎访问游客页面！");
    }
}
