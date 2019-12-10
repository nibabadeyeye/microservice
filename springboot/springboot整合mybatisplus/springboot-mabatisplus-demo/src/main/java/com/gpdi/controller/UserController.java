package com.gpdi.controller;

import com.gpdi.entity.User;
import com.gpdi.service.UserService;
import com.gpdi.util.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author : whs
 * @description:用户信息管理
 * @date 2019-08-18
 */

@RestController
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static Logger log = Logger.getLogger(UserController.class);

    /**
     * @descrition: 根据用户id查询用户信息
     */
    @RequestMapping(value = "getUserById")
    public ResponseData getUserById(int id) {
        long beginTime = System.currentTimeMillis();
        User user = userService.getUserById(id);
        long endTime = System.currentTimeMillis();
        System.out.println("This query take" + (endTime - beginTime));
        return new ResponseData(200, "请求成功", user);

    }

    /**
     * @descrition: 增加用户信息
     */
    @RequestMapping(value = "addUser")
    public ResponseData addUser(User user) {
        return new ResponseData(200, "添加用户成功", userService.addUser(user));

    }

    /**
     * @descrition: 根据用户id修改用户信息
     */
    @RequestMapping(value = "updateUser")
    public ResponseData updateUser(User user) {
        return new ResponseData(200, "修改用户成功", userService.updateUser(user));

    }

    /**
     * @descrition: 根据用户id删除用户信息
     */
    @RequestMapping(value = "delUserById")
    public ResponseData updateUser(int id) {
        return new ResponseData(200, "删除用户成功", userService.deleteUserById(id));
    }

    /**
     * @descrition: 根据用户区域查询用户信息
     */
    @RequestMapping(value = "getUserList")
    public ResponseData getUserList(String place) {
        log.info("当前执行的操作是getUesrList");
        return new ResponseData(200, "查询用户成功", userService.getUserList(place));
    }

    @RequestMapping(value = "getMap")
    public  Map<Integer, String>   getMap() {

        log.info("查询集合中的数据");
       // int a=1/0;
        Map<Integer, String> stateMap = new HashMap<>();
        List<Map<Integer, String>> mapList = userService.selOrdersState();
//        mapList.forEach((a)->{
//            System.out.println(a.keySet().iterator());
//        });

        for (Map<Integer, String> map : mapList) {
            String place = null;
            Integer id = null;
            for (Map.Entry<Integer, String> maps : map.entrySet()) {
                System.out.println("key" + maps.getKey());
                if ("id".equals(maps.getKey())) {
                    id = new Integer(String.valueOf(maps.getValue()));
                    System.out.println(String.valueOf(maps.getValue()));
                }
                if ("place".equals(maps.getKey())) {
                    place = String.valueOf(maps.getValue());
                    System.out.println(String.valueOf(maps.getValue()));
                }
                stateMap.put(id, place);
            }
        }
        return stateMap;
    }


    @Autowired
    UserService userService;
}
