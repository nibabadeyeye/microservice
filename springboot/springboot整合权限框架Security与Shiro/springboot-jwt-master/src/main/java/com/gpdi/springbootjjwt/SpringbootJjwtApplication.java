package com.gpdi.springbootjjwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gpdi.springbootjjwt.mapper")
public class SpringbootJjwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJjwtApplication.class, args);
    }
}
