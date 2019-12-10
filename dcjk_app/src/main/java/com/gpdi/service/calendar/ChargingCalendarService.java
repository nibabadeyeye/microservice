package com.gpdi.service.calendar;

import com.gpdi.common.respone.ResponseData;
/**
 *
 * @desc: 充电日历管理
 *
 */
public interface ChargingCalendarService {

    //查询充电记录
    public ResponseData getChargingCalendarTime(String imei);


    //查询放电记录
    public ResponseData getDisChargingCalendarTime(String imei);





}
