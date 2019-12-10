package com.gpdi.service.batteryinfo.impl;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.dao.battery.BatteryInfoMapper;
import com.gpdi.entity.battery.BatteryInfo;
import com.gpdi.service.batteryinfo.BatteryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BatteryInfoImpl implements BatteryInfoService {
    @Override
    public List<BatteryInfo> getBatteryInfoByRecentDays(String time) {
        return batteryInfoMapper.getBatteryInfoByRecentDays(time);
    }

    @Override
    public ResponseData insertBatteryList(List<BatteryInfo> list) {
         batteryInfoMapper.insertBatteryList(list);
        return new ResponseData(200,"",null);
    }

    @Override
    public ResponseData appLoginByBatteryIMEI(String IMEI) {
        ResponseData r = new ResponseData();
        int count = batteryInfoMapper.appLoginByBatteryIMEI(IMEI);
        if (count == 0) {
            r.setData("0");
            r.setMsg("登录失败，当前串号不存在");
            r.setStatus(200);
        } else {
            r.setData("1");
            r.setMsg("登录成功");
            r.setStatus(200);
        }
        return r;
    }



    @Override
    public ResponseData getBatteryInfoByIMEI(String iMEI) {
        ResponseData r = new ResponseData();
        BatteryInfo b=batteryInfoMapper.getBatteryInfoId(iMEI);
        BatteryInfo  b1=batteryInfoMapper.getBatteryInfoByTimeAndIMEI(b.getUploadTime(),iMEI);
        r.setMsg("请求成功");
        r.setData(b1);
        r.setStatus(200);
        return r;
    }

    @Autowired
    private BatteryInfoMapper batteryInfoMapper;
}
