package com.gpdi.web.video.entity;

/**
 * @desc:记录所有专家的微信信息
 */
public class Nature {
    //专家Id
    private int id;

    //专家用户ID
    private String uid;

    //人员性质（普通用户、专家）
    private String nature;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
