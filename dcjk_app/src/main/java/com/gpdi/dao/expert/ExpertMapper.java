package com.gpdi.dao.expert;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.entity.expect.Coordinates;

import java.util.List;

public interface ExpertMapper {


    //根据串号查询所有的经纬度信息
    public List<Coordinates> getAllCoordinateByIMEI(String iMEI);
}
