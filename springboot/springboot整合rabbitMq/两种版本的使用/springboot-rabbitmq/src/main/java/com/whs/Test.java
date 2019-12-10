package com.whs;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

//spring boot 的配置文件加载机制是什么？？？，为什么不扫描可以直接加载
//@Component
public class Test {


    private RabbitTemplate rabbitTemplate;
    public Test() {
        System.out.println("默认会进行输出？？？、");
      //  rabbitTemplate.convertAndSend(SpringbootRabbitmqApplication.queueName, "Hello from RabbitMQ!");
    }
}
