package com.whs.impl;

import com.whs.dao.LocationDao;
import com.whs.pojo.LocationEntity;
import com.whs.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationImpl implements LocationService {
    @Override
    public List<LocationEntity> getPoint() {
        return locationDao.getPoint();
    }
    @Autowired
    private LocationDao locationDao;
}
