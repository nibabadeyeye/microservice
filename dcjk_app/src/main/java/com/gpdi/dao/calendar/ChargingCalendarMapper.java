package com.gpdi.dao.calendar;



import java.util.List;

public interface ChargingCalendarMapper {

    //查询所有的充电记录
    public List<String> getChargingDate(String imei);

    //查询放电记录
    public  List<String> getDisChargingCalendarTime(String imei);

    //查询最近一次充电时间
    public String getFinalChargingTime(String imei);


}
