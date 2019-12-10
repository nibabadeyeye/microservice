package com.whs.pojo;

public class UserEntity {

    private int id;
    private String uname;
    private String upassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }
}
