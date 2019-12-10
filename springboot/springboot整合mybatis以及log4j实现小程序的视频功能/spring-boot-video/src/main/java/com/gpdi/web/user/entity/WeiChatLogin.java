package com.gpdi.web.user.entity;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class WeiChatLogin {

    private int id;
    private String wxAppid;
    private String wxUsername;
    private String wxUserPhone;
    private String wxUserIdnumber;
    private String wxUserArea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public String getWxUsername() {
        return wxUsername;
    }

    public void setWxUsername(String wxUsername) {
        this.wxUsername = wxUsername;
    }

    public String getWxUserPhone() {
        return wxUserPhone;
    }

    public void setWxUserPhone(String wxUserPhone) {
        this.wxUserPhone = wxUserPhone;
    }

    public String getWxUserIdnumber() {
        return wxUserIdnumber;
    }

    public void setWxUserIdnumber(String wxUserIdnumber) {
        this.wxUserIdnumber = wxUserIdnumber;
    }

    public String getWxUserArea() {
        return wxUserArea;
    }

    public void setWxUserArea(String wxUserArea) {
        this.wxUserArea = wxUserArea;
    }
}
