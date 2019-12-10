package com.whs.springBootxml;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
@ImportResource("context.xml")
@ComponentScan(basePackages = {"com.whs.*" ,"com.whs.springBootxml.dao"})
@SpringBootApplication
public class SpringBootXmlApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootXmlApplication.class, args);

	}
}
