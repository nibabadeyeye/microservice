package com.gpdi.web.item;
import com.gpdi.common.respone.ResponseData;
import com.gpdi.service.item.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("项目管理")
@RequestMapping("/items")//items/getChargingCalendar
public class ItemController {

    @ApiOperation("/获取充电时间")
    @PostMapping("/getChargingCalendar")
    public ResponseData getChargingCalendar(String iMEI) {
        return itemService.getBatteryItemsByDate(iMEI);
    }

    @Autowired
    private ItemService itemService;
}
