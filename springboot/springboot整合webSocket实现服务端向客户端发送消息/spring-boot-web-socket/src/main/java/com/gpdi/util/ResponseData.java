package com.gpdi.util;
/**
 *
 * @desc:封装自定义返回数据工具类
 *
 */
public class ResponseData {
    private int state;
    private String msg;
    private Object object;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ResponseData(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public ResponseData() {
    }

    public ResponseData(int state, String msg, Object object) {
        this.state = state;
        this.msg = msg;
        this.object = object;
    }
}
