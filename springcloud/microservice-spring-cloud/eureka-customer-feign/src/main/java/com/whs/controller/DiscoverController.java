package com.whs.controller;
import com.whs.service.IDicoverClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
@RestController
public class DiscoverController {


    @Resource
    IDicoverClient iDicoverClient;
    @GetMapping("/consumer")
    public String dc() {
      return iDicoverClient.consumer();
    }
}

