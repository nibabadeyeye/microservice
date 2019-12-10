package com.gpdi.controller;

import com.gpdi.provider.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {   

    @RequestMapping("/sendByFanoutExchange")
    public String sendByFanoutExchange() {
        mqSender.sendByFanoutExchangeMessage();
        System.out.println("发送消息");
        return "发送成功";
    }

    @RequestMapping("/sendByTopicExchange")
    public String sendByTopicExchange() {
        mqSender.sendByTopicExchangeMessage();
        System.out.println("发送消息");
        return "发送成功";
    }

    @RequestMapping("/sendByDirectExchange")
    public String sendByDirectExchange() {
        mqSender.sendByDirectExchangeMessage();
        System.out.println("发送消息");
        return "发送成功";
    }

    @Autowired
    private RabbitMqSender mqSender;
}
