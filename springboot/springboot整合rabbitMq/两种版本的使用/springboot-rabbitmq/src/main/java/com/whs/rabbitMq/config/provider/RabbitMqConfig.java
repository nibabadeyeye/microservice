package com.whs.rabbitMq.config.provider;
import com.whs.rabbitMq.config.consumer.appointMethod.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class RabbitMqConfig
{
    //定义一个队列
    public static String queueName = "spring-boot";
    @Bean
    Queue queue()
    {

        return new Queue(queueName, false);
    }
    //定义一个交换机
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }
    //将队列和交换机进行绑定
    @Bean
    Binding binding(Queue queue, TopicExchange exchange)
    {

        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    //基于注解形式的Bean
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory)
//    {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
//        factory.setAutoStartup(true);
//        return factory;
//    }


    /************************基于指定方法的形式*********************************/
    	@Bean
        SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}
    //监听者的实现
	@Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
		System.out.println("监听指定对象的指定方法！");
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

}
