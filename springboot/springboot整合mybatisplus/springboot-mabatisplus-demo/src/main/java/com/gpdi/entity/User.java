package com.gpdi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
/**
 * @description : 这里如果不加TableName,默认查询当前类User的对应user表
 *
 */
@TableName("sys_user")
public class User implements Serializable {
    private int id;
    private String name;
    private int state;
    private String username;
    private String place;
    private String tel;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
