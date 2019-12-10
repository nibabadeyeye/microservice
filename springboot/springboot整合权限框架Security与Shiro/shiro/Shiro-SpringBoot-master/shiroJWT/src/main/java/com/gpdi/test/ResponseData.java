package com.gpdi.test;

import java.util.HashMap;

/**
 * @desc：封装系统的返回参数，可以已Builder模式进行返回
 */

public class ResponseData extends HashMap {

    //返回状态码
    public ResponseData setCode(int code) {
        this.put("code", code);
        return this;
    }

    //返回请求的结果
    public ResponseData setResponseData(Object data) {
        this.put("data", data);
        return this;
    }

    //返回中文信息说明
    public ResponseData setMessage(String message) {
        this.put("message", message);
        return this;
    }



}
