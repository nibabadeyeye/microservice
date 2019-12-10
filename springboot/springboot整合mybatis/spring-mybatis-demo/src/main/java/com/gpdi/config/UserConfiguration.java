package com.gpdi.config;

import com.gpdi.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @desc:springBoot向Ioc中注入一个Bean
 *
 * */
@Configuration
public class UserConfiguration {

    @Bean(name = "user")
    public User getUser(){
      return  new User(1,"王华森");
    }
}
