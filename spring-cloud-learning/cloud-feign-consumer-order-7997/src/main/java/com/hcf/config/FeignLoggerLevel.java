package com.hcf.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerLevel {

    @Bean
    Logger.Level loggerLevelFeign() {
        return Logger.Level.FULL;
    }
}
