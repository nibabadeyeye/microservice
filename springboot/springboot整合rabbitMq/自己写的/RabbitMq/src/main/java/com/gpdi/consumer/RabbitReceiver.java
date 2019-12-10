package com.gpdi.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
/**
 * Created by Administrator on 2018/4/13.
 */
 
@Component
public class RabbitReceiver {
 
    @RabbitListener(queues = "fanout.A")
    public void receiverA(String msg){
        System.out.println("我接收的是fanout.A队列的消息"+msg);
    }
 
    @RabbitListener(queues = "fanout.B")
    public void receiverB(String msg){
        System.out.println("我接收的是fanout.B队列的消息"+msg);
    }
 
    @RabbitListener(queues = "fanout.C")
    public void receiverC(String msg){
        System.out.println("我接收的是fanout.C队列的消息"+msg);
    }

    @RabbitListener(queues = "topic.D")
    public void receiverD(String msg){
        System.out.println("我接收的是fanout.D队列的消息"+msg);
    }

    @RabbitListener(queues = "topic.E")
    public void receiverE(String msg){
        System.out.println("我接收的是fanout.E队列的消息"+msg);
    }

    @RabbitListener(queues = "direct.F")
    public void receiverFirst(String msg){
        System.out.println("我接收的是direct.First队列的消息"+msg);
    }
 
}
