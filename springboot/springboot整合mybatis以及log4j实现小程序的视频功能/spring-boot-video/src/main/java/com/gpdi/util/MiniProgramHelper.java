package com.gpdi.util;



/**
 * @Auther: Kevin Cui
 * @Date: 2018/11/6 18
 * @Description:
 */
public class MiniProgramHelper {

    public static final String      JS_CODE2_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APP_ID&secret=APP_SECRET&js_code=JSCODE&grant_type=authorization_code";

    //小程序访问AccessToken地址
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APP_ID&secret=APP_SECRET";

    //通过Api查询对应的信息（传入的信息主要有开发者的APPID，APPID_Secret(APPID密码，以及jsCode)）
    public String jscode2Session(String jscode) {
        return new HttpClientHelper().httpGet(JS_CODE2_SESSION_URL.replace("APP_ID", MiniProgramConstant.APP_ID).replace("APP_SECRET", MiniProgramConstant.APP_SECRET).replace("JSCODE", jscode));
    }

    /**
     * @desc:获取到的后台凭证
     */
    public String getAccessToken() {
        return new HttpClientHelper().httpGet(ACCESS_TOKEN_URL.replace("APP_ID", MiniProgramConstant.APP_ID).replace("APP_SECRET", MiniProgramConstant.APP_SECRET));
    }
}
