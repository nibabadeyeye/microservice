package com.gpdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;



@Configuration
public class MyBatisMapperScannerConfig {

  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mapperScannerConfigurer.setBasePackage("com.yhyr.mybatis.dynamic.mapper");
    Properties properties = new Properties();
    properties.setProperty("notEmpty", "false");
    properties.setProperty("IDENTITY", "MYSQL");
    mapperScannerConfigurer.setProperties(properties);
    return mapperScannerConfigurer;
  }
  
}
