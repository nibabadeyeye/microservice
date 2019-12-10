package com.gpdi.web.expect;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.service.expert.ExpertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("电池预计可使用")
@RequestMapping("/expect")//expect/getExpertByIMEI
public class ExpectController {


    @ApiOperation("/根据电池串号获取电池的经纬度信息")
    @PostMapping("/getCoordinate")
    public ResponseData getCoordinate(String iMEI) {
        return expertService.getAllCoordinateByIMEI(iMEI);
    }

    @Autowired
    private ExpertService expertService;
}
