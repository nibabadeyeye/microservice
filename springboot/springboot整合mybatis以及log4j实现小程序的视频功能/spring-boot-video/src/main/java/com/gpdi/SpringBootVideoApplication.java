package com.gpdi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@MapperScan(basePackages = {"com.gpdi.web.*.mapper"})
@SpringBootApplication
public class SpringBootVideoApplication {
	public static void main(String[] args) {
	      SpringApplication.run(SpringBootVideoApplication.class, args);

	}

}
