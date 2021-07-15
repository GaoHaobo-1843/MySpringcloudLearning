package com.gaohb.springcloud.apigateway.config;

import com.gaohb.springcloud.apigateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
