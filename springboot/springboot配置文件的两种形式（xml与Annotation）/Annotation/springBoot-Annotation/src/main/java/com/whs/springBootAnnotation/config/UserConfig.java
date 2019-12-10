package com.whs.springBootAnnotation.config;

import com.whs.springBootAnnotation.domain.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {


    @Bean(name="user")
    public UserEntity user()
    {
        UserEntity userEntity=new UserEntity();
        userEntity.setUid(666);
        userEntity.setUname("zero");
        userEntity.setUpassword("password");
        return userEntity;
    }
}
