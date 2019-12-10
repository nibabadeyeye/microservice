package com.whs.rabbitMq.config.provider;


import com.whs.rabbitMq.config.Entity.UserEntity;
import com.whs.rabbitMq.config.consumer.appointMethod.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SenderMessage implements CommandLineRunner {


    final static String queueName = "spring-boot";


    private final RabbitTemplate gupaoTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;
    //利用构造器进行初始化（amaq操作的工具，接收者对象，上下文是什么？？？）
    public SenderMessage(Receiver receiver, RabbitTemplate gupaoTemplate, ConfigurableApplicationContext context)
    {
        this.receiver = receiver;
        this.gupaoTemplate = gupaoTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {

        //这里默认会运行，如果不在这里发送消息
        System.out.println("Sending message...");

       UserEntity u=new UserEntity();
        u.setUid(1);
        u.setUname("zhang san");
        u.setUpassword("admin");
      //  gupaoTemplate.convertAndSend(RabbitMqConfig.queueName, "Hello,kkk");
     //   gupaoTemplate.
        gupaoTemplate.convertSendAndReceive(RabbitMqConfig.queueName, "Hello,kkk");
      //  receiver.getLatch().await(1000000, TimeUnit.MILLISECONDS);
   //     context.close();
    }


}