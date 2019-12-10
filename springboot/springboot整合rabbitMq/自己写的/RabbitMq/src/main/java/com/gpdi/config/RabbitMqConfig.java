package com.gpdi.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created by Administrator on 2019/11/13.
 */
@Configuration
public class RabbitMqConfig {


    /**
     * @desc:   广播交换机
     */
    @Bean(name = "Amessage")
    public Queue AMessage(){
        //其中Queue中两个参数为队列名称，及是否创建为永久队列（true），默认为false
        return new Queue("fanout.A",true);
    }

    @Bean(name = "Bmessage")
    public Queue BMessage(){
        return new Queue("fanout.B",true);
    }

    @Bean(name = "Cmessage")
    public Queue CMessage(){
        return new Queue("fanout.C",true);
    }


    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange"); //  配置广播路由器
    }

    // c.  按照规则绑定 队列Queue 和 交换机 fanoutExchange
    @Bean
    Binding bindingExchangeA(@Qualifier("Amessage")Queue aqueue,FanoutExchange exchange){
        return BindingBuilder.bind(aqueue).to(exchange);
    }

    @Bean
    Binding bindingExchangeB(@Qualifier("Bmessage")Queue bqueue,FanoutExchange exchange){
        return BindingBuilder.bind(bqueue).to(exchange);
    }

    @Bean
    Binding bindingExchangeC(@Qualifier("Cmessage")Queue cqueue,FanoutExchange exchange){
        return BindingBuilder.bind(cqueue).to(exchange);
    }


    /**
     * @desc: 主题交换机
     */
    @Bean("dQueue")
    public Queue dQueue(){
        return new Queue("topic.D",true);
    }

    @Bean("eQueue")
    public Queue eQueue(){
        return new Queue("topic.E",true);
    }


    //定义交换机
    @Bean("topicExchange")
    public TopicExchange getTopicExchange()
    {
        return new TopicExchange("topicExchange");
    }

    //绑定主题交换机与队列的关系(匹配规则：#代表一个字母，*代表一个单词)
    @Bean
    public Binding bindD(@Qualifier("dQueue")Queue queue, @Qualifier("topicExchange")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao.#");
    }


    @Bean
    public Binding bindE(@Qualifier("eQueue") Queue queue, @Qualifier("topicExchange")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.gupao.*");
    }

    /**
     * @desc: direct交换机
     */
    @Bean("fQueue")
    public Queue fQueue(){
        return new Queue("direct.F",true);
    }

    @Bean("directExchange")
    public DirectExchange getDirectExchange()
    {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindFirst(@Qualifier("fQueue") Queue queue, @Qualifier("directExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao.best");
    }


 





}
