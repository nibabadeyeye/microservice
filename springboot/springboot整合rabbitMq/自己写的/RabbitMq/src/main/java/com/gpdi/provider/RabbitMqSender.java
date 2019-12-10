package com.gpdi.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
/**
 * Created by Administrator on 2018/4/13.
 *
 * @desc : 自己封装的mq工具类
 */
 
@Component
public class RabbitMqSender {
 

 
    /**
      第一个参数  交换机名称(fanoutExchange)
      第二个参数  绑定规则(BindRules)
      第三个参数  发送的消息（message）
      因为这里是fanoutExchange ,即使配置了发送的routing_key也是不起作用的，故此处直接忽略参数2
     */

    //直连交换机发消息给队列
    public void sendByDirectExchangeMessage(){
        amqpTemplate.convertAndSend("directExchange","gupao.best","这是directExchange传递的消息");
    }
    //广播类型交换机
    public void sendByFanoutExchangeMessage(){
        amqpTemplate.convertAndSend("fanoutExchange","","这是fanoutExchange传递的消息");
    }


    //主题交换机
    public void sendByTopicExchangeMessage(){
        amqpTemplate.convertAndSend("topicExchange","gupao.a","这是topicExchangeD传递的消息");
        amqpTemplate.convertAndSend("topicExchange","changsha.gupao.student","这是topicExchangeE传递的消息");
    }



    @Autowired
    private AmqpTemplate amqpTemplate;

}
