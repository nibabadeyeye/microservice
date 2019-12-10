package com.gpdi.common.respone;

/**
 * @Auther: Kevin Cui
 * @Date: 18/6/28 10:47
 * @Description:
 */
public class ResponseData {

    public ResponseData() {
    }

    private int status;
    private String msg;
    private Object data;

    public ResponseData(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
