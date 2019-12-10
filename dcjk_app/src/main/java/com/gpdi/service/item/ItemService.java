package com.gpdi.service.item;


import com.gpdi.common.respone.ResponseData;

public interface ItemService {

    //电池条目管理（根据日期获取当前的电流、电压、以及温度值）
    public ResponseData getBatteryItemsByDate(String imei);



}
