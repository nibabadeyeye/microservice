package com.gpdi.springbootjjwt.data;

/**
 * @Auther: Kevin Cui
 * @Date: 2018/8/10 16
 * @Description:
 */
public class Code {
    public final static int OK = 200;//请求成功
    public final static int Unauthorized = 401;//需要权限
    public final static int NotLogin = 402;//没有登录
    public final static int Forbidden = 403;//请求服务器已经收到，但是服务器拒绝执行
    public final static int NotFound = 404;//路径错误
    public final static int InternalServerError = 500;//空指针异常
    public final static String InternalServerErrorMsg = "内部错误";
}
