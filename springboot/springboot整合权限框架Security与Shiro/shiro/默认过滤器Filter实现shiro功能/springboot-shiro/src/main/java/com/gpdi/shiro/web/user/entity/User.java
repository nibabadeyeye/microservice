package com.gpdi.shiro.web.user.entity;

public class User {
    //用户ID
    private int uid;
    //用户名称
    private String username;
    //用户密码
    private String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int uid, String username) {
        this.uid = uid;
        this.username = username;
    }
}
