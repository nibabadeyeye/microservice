package com.gupaoedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *使用rabbitmq 的优点：1.异步处理：提高工作效率
 *                     2.解耦：减少多个业务之前的依赖关系（a---->b----->c）
 *                     3.削峰（淘宝购物时请求过多时让用户进行排队等待）
 */
@SpringBootApplication
@MapperScan("com.gupaoedu.mapper")
public class ProducerApp {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApp.class, args);
	}
}
