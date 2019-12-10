package com.gpdi.user.service;

import com.gpdi.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

/**
 * @description: 提供用户服务
 *
 */
@FeignClient(value = "user-service")
public interface UserService {

    /**
     * 添加用户
     */
    @PostMapping(value = "/user/save")
    public boolean saveUser(User user);
    /**
     * 查询用户信息
     */
    @GetMapping(value = "/user/getAllUser")
    public List<User> getAllUser();

}
