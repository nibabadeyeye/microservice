package com.gpdi.dao;

import com.gpdi.entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BusinessDao {
    //@Select("${value}")
    public List<Business> getBusinessListBySql(String sql);
}
