package com.whs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(value={"com.whs.*", "com.whs.utily"})
@SpringBootApplication
public class RedisDemoApplication {

//	@Bean
////	public StringRedisTemplate stringRedisTemplate()
////	{
////		return new StringRedisTemplate();
////	}
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}
}
