package com.gpdi.annotation.current;

import com.gpdi.annotation.other.OtherConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(OtherConfiguration.class)
@Configuration
public class CurrentConfiguration {

    @Bean("currentDemo")
    public CurrentDemo getCurrentDemo(){
        return new CurrentDemo();
    }
}

