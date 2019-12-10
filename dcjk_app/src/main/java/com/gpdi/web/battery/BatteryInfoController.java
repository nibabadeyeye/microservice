package com.gpdi.web.battery;


import com.gpdi.common.respone.ResponseData;
import com.gpdi.service.batteryinfo.BatteryInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 电池信息管理
 */
@RestController
@RequestMapping("/batteryInfo")//batteryInfo/getBatteryInfoByIMEI
public class BatteryInfoController {


    @ApiOperation("app端电池串号登录")
    @PostMapping("/appLoginByIMEI")
    public ResponseData appLoginByIMEI(String iMEI) {
        return batteryInfoService.appLoginByBatteryIMEI(iMEI);
    }

    @ApiOperation("通过串号获取电池详细信息")
    @PostMapping("/getBatteryInfoByIMEI")
    public ResponseData getBatteryInfoByIMEI(String iMEI) {
        return batteryInfoService.getBatteryInfoByIMEI(iMEI);
    }


    @Autowired
    private BatteryInfoService batteryInfoService;
}
