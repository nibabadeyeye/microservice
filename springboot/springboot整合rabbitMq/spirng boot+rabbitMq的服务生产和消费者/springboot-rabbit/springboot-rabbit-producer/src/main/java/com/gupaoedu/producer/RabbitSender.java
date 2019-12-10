package com.gupaoedu.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gupaoedu.entity.Merchant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: qingshan
 * @Date: 2018/10/20 16:52
 * @Description: 咕泡学院，只为更好的你
 */
@Component
@PropertySource("classpath:gupaomq.properties")
public class RabbitSender {

    //指定交换机：指定交换机名称和路由用队列进行一对一的消息投递
    @Value("${com.gupaoedu.directexchange}")
    private String directExchange;

    //主题交换机，可以根据路由规则发送到交换机的一个或者多个队列上进行消息投递
    @Value("${com.gupaoedu.topicexchange}")
    private String topicExchange;

    //扇形交换机：也可以进行多个队列的消息投递
    @Value("${com.gupaoedu.fanoutexchange}")
    private String fanoutExchange;

    @Value("${com.gupaoedu.directroutingkey}")
    private String directRoutingKey;


    @Value("${com.gupaoedu.topicroutingkey1}")
    private String topicRoutingKey1;

    @Value("${com.gupaoedu.topicroutingkey2}")
    private String topicRoutingKey2;


    // 自定义的模板，所有的消息都会转换成JSON发送（自定义json格式的模板）
    @Autowired
    AmqpTemplate gupaoTemplate;

    public void send() throws JsonProcessingException {
        Merchant merchant =  new Merchant(1001,"a direct msg : 中原镖局","汉中省解放路266号");
        //1、直连交换机（directExchange,gupao.best,merchant）,一对一的传递
        gupaoTemplate.convertAndSend(directExchange,directRoutingKey, merchant);
        //2.1、主题交换机（topicExchange，shanghai.gupao.teacher，"teacher"）,会匹配一个或者多个队列（这里面只配置了一个）

        //2.2、主题交换机（topicExchange，shanghai.gupao.student，"student"）
        gupaoTemplate.convertAndSend(topicExchange,topicRoutingKey1,"a topic msg : shanghai.gupao.teacher");
        gupaoTemplate.convertAndSend(topicExchange,topicRoutingKey2,"a topic msg : changsha.gupao.student");
        // 发送JSON字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(merchant);
        System.out.println(json);
        //扇形交换机（会发送所有交换机名称为fanoutExchange的交换机）
        gupaoTemplate.convertAndSend(fanoutExchange,"", json);
    }


}
