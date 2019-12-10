package com.whs.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eureka-client-provider")
public interface IDicoverClient {

    @RequestMapping(value = "/dc", method= RequestMethod.GET)
    String consumer();
}
