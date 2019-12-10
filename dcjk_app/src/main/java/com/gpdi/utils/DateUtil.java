package com.gpdi.utils;

/**
 * @desc: 时间操作工具类
 */
public class DateUtil {

    //将毫秒转化为多少天、多少小时、多少分钟
    public static String getTime(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + "天" + hours + "小时" + minutes + "分钟";
    }
}
