package com.gpdi.spi;

import com.gpdi.GpdiCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(Application.class,args);
        System.out.println(context.getBean("gpdiCore"));
        GpdiCore gpdiCore=context.getBean(GpdiCore.class);
        gpdiCore.study();
    }


}
