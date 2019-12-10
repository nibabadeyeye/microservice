package com.example.AddDemo.domain;

import java.io.Serializable;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class User implements Serializable {


    private int id;
    private String name;

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
}
