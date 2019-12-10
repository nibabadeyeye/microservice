package com.gpdi.service;

import com.gpdi.dao.BusinessDao;
import com.gpdi.entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    public List<Business> getBussinesListBySql(String sql){
        return this.businessDao.getBusinessListBySql(sql);
    };

    @Autowired
    BusinessDao businessDao;
}
