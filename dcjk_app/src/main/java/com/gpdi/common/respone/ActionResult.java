package com.gpdi.common.respone;

import java.util.Map;

/**
 * @Author Zhb
 * @Date 2019/6/25 17:22
 **/
public class ActionResult {

    private int code;
    private String msg;
    private Object data;
    private Map<String,Object> extra;

    public ActionResult() {

    }

    public ActionResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ActionResult ok() {
        return new ActionResult(200, "ok", null);
    }

    public static ActionResult ok(String msg) {
        return new ActionResult(200, msg, null);
    }

    public static ActionResult ok(Object data) {
        return new ActionResult(200, "ok", data);
    }

    public static ActionResult ok(String msg, Object data) {
        return new ActionResult(200, msg, data);
    }

    public static ActionResult error(String msg) {
        return new ActionResult(500, msg, null);
    }

    public static ActionResult error(String msg, Object data) {
        return new ActionResult(500, msg, data);
    }

    public static ActionResult error(int code, String msg, Object data) {
        return new ActionResult(code, msg, data);
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

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
