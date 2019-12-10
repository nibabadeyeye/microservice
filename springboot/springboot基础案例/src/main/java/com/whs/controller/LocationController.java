package com.whs.controller;

import com.whs.pojo.LocationEntity;
import com.whs.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    //查询地图标注点信息
    @RequestMapping(value = "getPoint")
    public List<LocationEntity> getPoint()
    {
        return locationService.getPoint();
    }
    @Autowired
    private LocationService locationService;
}
