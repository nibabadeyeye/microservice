package com.gpdi.schedule;

import com.alibaba.fastjson.JSONObject;
import com.gpdi.dao.battery.BatteryInfoMapper;
import com.gpdi.entity.battery.BatteryInfo;
import com.gpdi.utils.ApiDataUtils;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RestController
public class BatteryJob1 {
    /**
     * @description:5分钟同步一次电池数据，只做增量而不是全部重新插入数据
     */
    @Scheduled(fixedRate = 1000 * 6 * 10 * 5)
    private void exceptionJob() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateee = new Date();
        String time = simpleDateFormat.format(dateee);
        logger.info(time + "执行定时任务");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

       calendar.add(Calendar.DATE, -5);
        long from = calendar.getTime().getTime() / 1000;
        Calendar calendar1 = Calendar.getInstance();
        long to = calendar1.getTime().getTime() / 1000;
        try {
            // String code = "test010";
            String code = "test010";
            JSONObject list = (JSONObject) ApiDataUtils.getDistrict(from, to, code);
            JSONObject jsonObject = new JSONObject((Map<String, Object>) list.get("data"));
            Map map = new HashMap();
            map.put("total", jsonObject.get("total"));
            map.put("list", jsonObject.get("datas"));
            String changeStrBefore = jsonObject.get("datas").toString();
            List<BatteryInfo> oldDistrictList = new ArrayList<>();
            JSONArray jsonArray = JSONArray.fromObject(changeStrBefore);
            System.out.println(jsonArray.size());
            if (jsonArray.size() > 0) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    BatteryInfo oldDistrict = new BatteryInfo();
                    try {
                        oldDistrict.setUploadTime(jsonArray.getJSONObject(i).getString("logdt"));

                    } catch (Exception e) {

                    }
                    try {
                        oldDistrict.setDeviceType(jsonArray.getJSONObject(i).getString("devicemodel"));

                    } catch (Exception e) {

                    }
                    try {
                        oldDistrict.setCmd(jsonArray.getJSONObject(i).getInt("datainfo-cmd"));

                    } catch (Exception e) {

                    }

                    try {
                        oldDistrict.setNumber(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryNum"));
                    } catch (Exception e) {

                    }
                    try {
                        oldDistrict.setVoltageValue1(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_1"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue2(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_2"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue3(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_3"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue4(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_4"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue5(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_5"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue6(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_6"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue7(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_7"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue8(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_8"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue9(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_9"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue10(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_10"));

                    } catch (Exception e) {
                    }

                    try {
                        oldDistrict.setVoltageValue11(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_11"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue12(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_12"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setVoltageValue13(jsonArray.getJSONObject(i).getInt("datainfo-content-batteryPower_13"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setState(jsonArray.getJSONObject(i).getInt("datainfo-content-charge_state"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setCoordinate(jsonArray.getJSONObject(i).getString("datainfo-content-coordinate"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setCurrent(jsonArray.getJSONObject(i).getString("datainfo-content-electricy"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setResidualPercentage(jsonArray.getJSONObject(i).getString("datainfo-content-residual_electricity"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setResistanceTemperature1(jsonArray.getJSONObject(i).getInt("datainfo-content-temperature_1"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setResistanceTemperature2(jsonArray.getJSONObject(i).getInt("datainfo-content-temperature_2"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setResistanceTemperature3(jsonArray.getJSONObject(i).getInt("datainfo-content-temperature_3"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setWorkPattern(jsonArray.getJSONObject(i).getString("datainfo-content-workType"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setImei(jsonArray.getJSONObject(i).getString("datainfo-cpsn"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setServerTag(jsonArray.getJSONObject(i).getString("datainfo-serverTag"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setTag(jsonArray.getJSONObject(i).getString("datainfo-tag"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setHostInfo(jsonArray.getJSONObject(i).getString("hostinfo"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setResponse(jsonArray.getJSONObject(i).getString("responselistname"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setWriteTime(jsonArray.getJSONObject(i).getString("timestamp"));

                    } catch (Exception e) {
                    }
                    try {
                        oldDistrict.setRecordNumber(jsonArray.getJSONObject(i).getString("_id"));

                    } catch (Exception e) {
                    }
                    oldDistrictList.add(oldDistrict);

                }

                //查询最近3天上传的数据库记录
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.DATE, -7);
                Date d = c.getTime();
                String day = s.format(d);
                List<BatteryInfo> dateList = districtService.getBatteryInfoByRecentDays(day);
                logger.info("数据库数据的长度" + dateList.size() + "  定时任务的长度" + oldDistrictList.size());
                Map<Object, Integer> stringIntegerMap = new ConcurrentHashMap<>();
                dateList.forEach(a -> {
                    stringIntegerMap.put(a.getRecordNumber(), 1);
                });
                //删除重复的数据（RecordNumber重复）
                for (int i = 0; i < oldDistrictList.size(); i++) {
                    if (stringIntegerMap.containsKey(oldDistrictList.get(i).getRecordNumber())) {
                        oldDistrictList.remove(oldDistrictList.get(i));
                        i--;
                    }
                }
                logger.info("更新的数据长度  " + oldDistrictList.size());
                if (oldDistrictList.size() > 0) {
                    districtService.insertBatteryList(oldDistrictList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private BatteryInfoMapper districtService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


}
