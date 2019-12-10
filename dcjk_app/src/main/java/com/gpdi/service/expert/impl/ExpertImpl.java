package com.gpdi.service.expert.impl;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.dao.expert.ExpertMapper;
import com.gpdi.entity.expect.Coordinates;
import com.gpdi.service.expert.ExpertService;
import com.gpdi.utils.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpertImpl implements ExpertService {
    @Override
    public ResponseData getAllCoordinateByIMEI(String iMEI) {
        Map map = new HashMap();
        //获取所有的经纬度信息
        List<Coordinates> coordinatesList = expertMapper.getAllCoordinateByIMEI(iMEI);
        map.put("coordinateList", coordinatesList);
        //获取最早的时间和最晚时间的经纬度信息
        if (coordinatesList.size() > 1) {
            double beginLongitude = Double.parseDouble(coordinatesList.get(0).getLongitude());
            double beginLatitude = Double.parseDouble(coordinatesList.get(0).getLatitude());
            double endLongitude = Double.parseDouble(coordinatesList.get(coordinatesList.size() - 1).getLongitude());
            double endLatitude = Double.parseDouble(coordinatesList.get(coordinatesList.size() - 1).getLatitude());
            double distance = LocationUtils.getDistance(beginLatitude, beginLongitude, endLatitude, endLongitude);
            map.put("distance", distance);
        }


        return new ResponseData(200, "请求成功", map);
    }


    @Autowired
    private ExpertMapper expertMapper;
}
