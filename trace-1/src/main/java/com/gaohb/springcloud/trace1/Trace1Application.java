package com.gaohb.springcloud.trace1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Trace1Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace1Application.class, args);
    }

}
