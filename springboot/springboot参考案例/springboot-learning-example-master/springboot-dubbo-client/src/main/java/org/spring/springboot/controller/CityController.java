package org.spring.springboot.controller;

import org.spring.springboot.ClientApplication;
import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.CityDubboConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @GetMapping(value="test")
    public void test(String name)
    {
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, name);
        CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
        cityService.printCity();
       //  return city.toString();

    }
}
