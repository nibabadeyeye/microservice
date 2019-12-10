package com.whs.service;




public interface StringService {

    //增加用户信息
    public  void  addUser(String key,String value);
    //删除用户
    public void deleteUser(String key);
    //修改用户
    public void updateUser(String key,String value);
    //查询一个用户
    public String queryOne(String key);

}
