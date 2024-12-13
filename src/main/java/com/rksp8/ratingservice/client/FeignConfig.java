package com.rksp8.ratingservice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignUserInterceptor feignUserInterceptor() {
        return new FeignUserInterceptor();
    }
}