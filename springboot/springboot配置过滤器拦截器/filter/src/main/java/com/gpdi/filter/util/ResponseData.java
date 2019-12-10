package com.gpdi.filter.util;

/**
 * @Auther: Kevin Cui
 * @Date: 18/6/28 10:47
 * @Description:
 */
public class ResponseData {
    private int code;
    private String msg;
    private Object data;

    public ResponseData(int status, String msg) {
        this.code = status;
        this.msg = msg;
    }

    public ResponseData(int status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
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
