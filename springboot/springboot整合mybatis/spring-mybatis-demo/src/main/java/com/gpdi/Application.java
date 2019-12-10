package com.gpdi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        String arr[] = context.getBeanDefinitionNames();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
