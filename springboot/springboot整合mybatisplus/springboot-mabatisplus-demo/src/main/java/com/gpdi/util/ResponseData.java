package com.gpdi.util;
/**
 * @description:封装请求返回的信息
 *
 */
public class ResponseData {
    //请求返回的状态码
    private int code;
    //请求返回的状态信息
    private String msg;
    //请求返回的状态
    private Object data;

    public ResponseData() {
    }

    public ResponseData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
