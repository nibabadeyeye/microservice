package com.whs;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaCustomerFeignApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaCustomerFeignApplication.class).run();
    }

}
