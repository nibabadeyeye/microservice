package com.gpdi.service.calendar.impl;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.dao.calendar.ChargingCalendarMapper;
import com.gpdi.service.calendar.ChargingCalendarService;
import com.gpdi.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChargingCalendarImpl implements ChargingCalendarService {


    @Override
    public ResponseData getDisChargingCalendarTime(String imei) {
        List<String> dateList = chargingCalendarMapper.getDisChargingCalendarTime(imei);
        Map map = new HashMap();
        map.put("dateList", dateList);
        map.put("days", dateList.size());
        return new ResponseData(200, "请求成功", map);
    }

    @Override
    public ResponseData getChargingCalendarTime(String imei) {
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<String> dateList = chargingCalendarMapper.getChargingDate(imei);
        Map map = new HashMap();
        //查询最近的一次充电时间
        String time = chargingCalendarMapper.getFinalChargingTime(imei);
        SimpleDateFormat historyFormat = new SimpleDateFormat(time);
        long value = 0;
        try {
            long t1 = System.currentTimeMillis();
            long t2 = currentDateFormat.parse(time).getTime();
            value = t2 - t1;
        } catch (Exception e) {

        }
        String stringTime = DateUtil.getTime(value);
        map.put("latestChargingTime", stringTime);
        map.put("dateList", dateList);
        map.put("days", dateList.size());
        return new ResponseData(200, "请求成功", map);
    }


    private DateUtil dateUtil = new DateUtil();
    @Autowired
    private ChargingCalendarMapper chargingCalendarMapper;
}
