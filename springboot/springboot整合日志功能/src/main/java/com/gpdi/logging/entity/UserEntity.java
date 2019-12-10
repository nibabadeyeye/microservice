package com.gpdi.logging.entity;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class UserEntity {
    public UserEntity(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    private int id;
    private String name;
    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
