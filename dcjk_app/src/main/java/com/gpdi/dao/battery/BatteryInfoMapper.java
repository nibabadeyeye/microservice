package com.gpdi.dao.battery;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.entity.battery.BatteryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @desc: 电池信息管理接口
 *
 */
public interface BatteryInfoMapper {

    //根据电池的编号进行登录
    public int appLoginByBatteryIMEI(String IMEI);

    //根据串号查询电池的相关信息
    public BatteryInfo getBatteryInfoByTimeAndIMEI(@Param("date") String date,@Param("imei")  String  imei);

    //根据串号查询电池的相关信息
    public BatteryInfo getBatteryInfoId(String IMEI);

    //批量插入数
    void insertBatteryList(List<BatteryInfo> list);

    //充电日历管理
    public List<String> getChargingCalendar();

    //查询最近三天所有的电池的主键信息
    public List<BatteryInfo> getBatteryInfoByRecentDays(String time);
}
