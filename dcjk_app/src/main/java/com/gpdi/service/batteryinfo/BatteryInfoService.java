package com.gpdi.service.batteryinfo;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.entity.battery.BatteryInfo;

import java.util.List;

/**
 *
 * @desc: 电池信息管理接口
 *
 */
public interface BatteryInfoService {

    //根据电池的编号进行登录
    public ResponseData appLoginByBatteryIMEI(String IMEI);

    //根据串号查询电池的相关信息
    public ResponseData getBatteryInfoByIMEI(String IMEI);

    //批量插入电池信息
    public ResponseData insertBatteryList(List<BatteryInfo> list);

    //查询最近三天所有的电池的主键信息
    public List<BatteryInfo> getBatteryInfoByRecentDays(String time);
}
