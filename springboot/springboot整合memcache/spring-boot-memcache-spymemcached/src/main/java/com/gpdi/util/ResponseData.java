package com.gpdi.util;

public class ResponseData {
    private String msg;
    private  int code;
    private Object object;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ResponseData() {
    }

    public ResponseData(String msg, int code, Object object) {
        this.msg = msg;
        this.code = code;
        this.object = object;
    }

    public ResponseData(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
}
