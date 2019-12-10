package com.gpdi.dao.item;

import com.gpdi.entity.item.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    //根据日期当天的充电电流信息
    public List<Item> getRechargeCurrentByDateByDate(@Param("date") String date,@Param("imei") String imei);

    //根据日期当天的充电电压信息
    public List<Item> getRechargeVoltageByDate(@Param("date") String date,@Param("imei") String imei);

    //根据日期当天的充电电阻信息
    public List<Item> getRechargeTemperatureByDate(@Param("date") String date,@Param("imei") String imei);

    //查询最大的充电天数
    public String getMaxRechargeDateFromIMEI(String imei);
}
