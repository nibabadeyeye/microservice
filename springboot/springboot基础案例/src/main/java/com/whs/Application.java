package com.whs;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@ComponentScan(basePackages ={"com.whs.*","com.whs.dao"} )
@MapperScan(basePackages = "com.whs.dao")
@EnableCaching
public class Application
{

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
