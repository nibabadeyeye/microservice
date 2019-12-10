package com.whs;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.whs", "com.whs.config"})
@SpringBootApplication
public class SpringbootRabbitmqApplication {

	//注册一个json格式的Bean
	@Bean
	public RabbitTemplate gupaoTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}


	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}
}
