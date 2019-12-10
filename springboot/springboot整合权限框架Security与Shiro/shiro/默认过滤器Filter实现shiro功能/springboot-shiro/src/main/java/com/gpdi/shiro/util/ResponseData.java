package com.gpdi.shiro.util;
/**
 *  响应封装工具类
 */
public class ResponseData {
    //状态码
    private int code;
    //返回数据
    private Object data;
    //返回提示
    private String msg;

    public ResponseData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ResponseData(int code, String msg, String token) {
        this.code = code;
        this.msg = msg;

    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
