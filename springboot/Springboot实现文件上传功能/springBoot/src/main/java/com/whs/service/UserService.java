package com.whs.service;

import com.whs.pojo.UserEntity;

import java.util.List;

public interface UserService {
    // 查询用户信息
    public List<UserEntity> queryUserList();

    //增加用户信息
    public  void  addUser(UserEntity user);
    //删除用户
    public void deleteUser(int id);
    //修改用户
    public void updateUser(UserEntity user);
    //查询一个用户
    public UserEntity queryOne(int id);
}
