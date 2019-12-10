package com.gpdi.common.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponserData implements Serializable{

    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;

    public static ResponserData build(Integer status, String msg, Object data) {
        return new ResponserData(status, msg, data);
    }

    public static ResponserData ok(Object data) {
        return new ResponserData(data);
    }

    public static ResponserData ok() {
        return new ResponserData(null);
    }

    public ResponserData() { }

    public static ResponserData build(Integer status, String msg) {
        return new ResponserData(status, msg, null);
    }

    public ResponserData(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponserData(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public ResponserData(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
