package com.gpdi.service.item.impl;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.dao.item.ItemMapper;
import com.gpdi.entity.item.Item;
import com.gpdi.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemImpl implements ItemService {
    @Override
    public ResponseData getBatteryItemsByDate(String imei) {
        String date=itemMapper.getMaxRechargeDateFromIMEI(imei);
        Map map = new HashMap();
        if(date!=null){
            //电流值
            List<Item> currentList = itemMapper.getRechargeCurrentByDateByDate(date, imei);
            currentList.forEach(a -> {

                try {
                    a.setItemName("电流值");

                }catch (Exception e){

                }
            });
            //电压值
            List<Item> voltageList = itemMapper.getRechargeVoltageByDate(date, imei);
            voltageList.forEach(a -> {

                try {
                    a.setItemName("电压值");

                }catch (Exception e){

                }
            });

            //电阻值
            List<Item> temperatureList = itemMapper.getRechargeTemperatureByDate(date, imei);
            temperatureList.forEach(a -> {
                try {
                    a.setItemName("电阻值");
                }catch (Exception e){

                }

            });

            map.put("currentList", currentList);
            map.put("voltageList", voltageList);
            map.put("temperatureList", temperatureList);

            return new ResponseData(200, "请求成功", map);
        }
        return new ResponseData(200, "请求成功", map);
    }

    @Autowired
    private ItemMapper itemMapper;
}
