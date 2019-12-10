//package com.whs.rabbitMq.config.consumer.annotation;
//import com.whs.rabbitMq.config.Entity.UserEntity;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//@Component
//@RabbitListener(queues = "spring-boot", containerFactory="rabbitListenerContainerFactory")
//public class ListernAdapter {
//
//
//    @RabbitHandler
//    public void process(@Payload UserEntity merchant){
//        System.out.println("First Queue received msg : " + merchant.getUname());
//    }
//
//
//}
