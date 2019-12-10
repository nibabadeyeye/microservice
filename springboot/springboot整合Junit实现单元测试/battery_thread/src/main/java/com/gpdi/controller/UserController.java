package com.gpdi.controller;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    /**
     *
     * @param
     *         name 用户姓名
     *         request Http对象
     *
     * @return String
     *
     */
    @GetMapping(value = "getStringByName")
    public String getStringByName(String name,HttpServletRequest request) {

        return "Hello," + name+" ,今天是"+request.getAttribute("date");
    }


    @GetMapping(value = "getStringByPassString")
    public String getStringByPassString(HttpServletRequest request) {
        Object name=request.getAttribute("name");
        return "Hello," + name;
    }

    @PostMapping(value = "getString")
    public String getString() {
        return "talk with friend";
    }

    @GetMapping(value = "getList")
    public List getList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        return list;
    }
    @PostMapping(value = "passByJson")
    public String passByJson(@RequestBody JSONObject jsonParam){

        String name=jsonParam.getString("name");
        int id=jsonParam.getInteger("id");
        System.out.println("id"+id+"name  "+name);
        return jsonParam.toJSONString();
    }
}
