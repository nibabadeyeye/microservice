package com.gpdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	/**
	 * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}
	// springboot运行后此方法首先被调用
	// 实现CommandLineRunner抽象类中的run方法
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}


}
