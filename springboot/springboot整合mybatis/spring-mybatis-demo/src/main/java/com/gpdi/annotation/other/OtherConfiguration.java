package com.gpdi.annotation.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfiguration {
    @Bean("otherDemo")
    public OtherDemo getOtherDemo(){
        return new OtherDemo();
    }
}
