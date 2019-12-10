package com.gpdi.web.calendar;


import com.gpdi.common.respone.ResponseData;
import com.gpdi.service.calendar.ChargingCalendarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("充电日历管理")
@RequestMapping("/calendar")//calendar/getDisChargingCalendar
@RestController
public class ChargingCalendarController {

    @ApiOperation("/获取充电时间")
    @PostMapping("/getChargingCalendar")
    public ResponseData getChargingCalendar(String iMEI) {
        return chargingCalendarService.getChargingCalendarTime(iMEI);
    }

    @ApiOperation("/获取放电时间")
    @PostMapping("/getDisChargingCalendar")
    public ResponseData getDisChargingCalendar(String iMEI) {
        return chargingCalendarService.getDisChargingCalendarTime(iMEI);
    }

    @Autowired
    private ChargingCalendarService chargingCalendarService;
}
