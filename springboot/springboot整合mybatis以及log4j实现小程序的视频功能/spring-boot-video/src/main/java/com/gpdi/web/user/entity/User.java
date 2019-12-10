package com.gpdi.web.user.entity;


import java.io.Serializable;
/**
 *
 * @descripiton:微信用户登录信息表
 *
 */

public class User implements Serializable {

    //用户Id
    private String uid;
    //用户昵称
    private String nickName;
    //图片
    private String avatarUrl;
    //用户性别
    private String gender;
    //用户省份
    private String province;
    //用户城市
    private String city;
    //用户国家
    private String country;




    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
