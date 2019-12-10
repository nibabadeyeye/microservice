package com.whs.service;

import com.whs.pojo.UserEntity;
import com.whs.pojo.ltudeEntity;


import java.util.List;

public interface UserService {
    // 查询用户信息
    public List<UserEntity> queryUserListByCache();
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
    /*** 发送简单邮件*/
    public void sendSimpleEmail(String to, String subject, String content);

    /*** 发送带附件的邮件*/
    public void sendAttachmentsEmail(String to, String subject, String content, String filePath);
    /*** 发送带静态资源的邮件*/
    public void sendInlineResourceEmail(String to, String subject, String content, String rscPath, String rscId);
    //配合事务观察是否回滚
    public void tetTransAction(UserEntity user);

    //查询test表中的经纬度信息
    public List<ltudeEntity> getAll();
    //根据经纬度查询地址信息
    public ltudeEntity get(String longtitude,String la);


}
