package com.gpdi.user.service;

import com.gpdi.user.entity.User;

import java.util.List;

/**
 * @description:提供用户服务的接口
 *
 */
public interface UserService {

    /**
     * 添加一个用户
     */
    public void addUser(User user);

    /**
     * 查询用户信息
     */
    public List<User> getAllUser();

}
