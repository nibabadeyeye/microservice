package com.gpdi.utils;

import com.alibaba.fastjson.JSONArray;

/**
 * @Author: JaceLai
 * @Date: 2019/7/22/022 15:36
 * @Description: 取数据统一工具类
 */
public class ApiDataUtils {

    /**
     * @param from 开始时间
     * @param to   结束时间
     * @param code 编码
     * @return
     */
    public static Object getDistrict(long from, long to, String code) {
        String url = "http://bms.szyac.cn/api/get?from=" + from + "&to=" + to + "" + "&code=" + code + "";
        String result = HttpClientHelper.httpGet(url);
        return JSONArray.parse(result);
    }
}
