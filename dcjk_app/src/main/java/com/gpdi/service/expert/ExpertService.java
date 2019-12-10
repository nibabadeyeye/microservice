package com.gpdi.service.expert;

import com.gpdi.common.respone.ResponseData;

public interface ExpertService {

    //根据串号查询所有的经纬度信息
    public ResponseData getAllCoordinateByIMEI(String iMEI);
}
