package com.gpdi.controller;//package com.gpdi.controller;

import com.gpdi.service.UserServiceProxy;
import com.gpdi.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@RestController
public class UserController {

    @Autowired
    private UserServiceProxy userService;

    /**
     *
     * 保存一个用户
     */
    @PostMapping("/user/save")
    public void saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userService.addUser(user);

    }

    /**
     *
     *
     * @return 所有的用户数据
     */
    @GetMapping("/user/list")
    public List<User> list() {
        return userService.getAllUser();
    }


    /**
     * @desc:获取请求服务实例
     *
     */
    @GetMapping("/consumer")
    public String dc() {
         ServiceInstance serviceInstance = loadBalancerClient.choose("user-service-provider");
        //获取一个实例的具体Ip地址和端口
         String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
         System.out.println(" 服务的请求地址 "+url);
        // return restTemplate.getForObject(url, String.class);
        return url;
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;


}
