package com.whs.dao;

import com.whs.pojo.LocationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationDao {
    @Select("select id,name,code,longitude,latitude from test limit 10")
    public List<LocationEntity> getPoint();
}
