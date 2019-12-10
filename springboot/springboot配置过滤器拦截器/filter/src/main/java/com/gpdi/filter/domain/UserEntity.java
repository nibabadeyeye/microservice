package com.gpdi.filter.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class UserEntity implements Serializable {
     private int uid;
     private String uname;
     private String upassword;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uid == that.uid &&
                Objects.equals(uname, that.uname) &&
                Objects.equals(upassword, that.upassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, upassword);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }
}
