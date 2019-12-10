package com.gpdi.config.corss;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Zhb
 * @Date 2019/6/27 10:25
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * @description: 跨域支持
     */


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }

}
