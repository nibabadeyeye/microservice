package com.gpdi.config.druid;

import javax.sql.DataSource;
 
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.alibaba.druid.pool.DruidDataSource;
/**
 *
 * @description: 将druid已Bean的形势注册到Spring容器中交给Spring 容器进行筒体的管理
 *
 */
@Configuration
@ServletComponentScan
public class DruidConfig {
	@Bean
	//加载时读取指定的配置信息,前缀为spring.datasource.druid
	@ConfigurationProperties(prefix="spring.datasource.druid")
	public DataSource druidDataSource()
	{
		return new DruidDataSource();
	}
}
