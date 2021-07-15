package com.gaohb.springcloud.eurekaconsumerribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }

    @Service
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback") // 服务降级核心注解，用于服务消费者中，那些消费其它可能出现无法正常调用服务或可能出现异常的方法之上
        public String consumer() {
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        public String fallback() {
            return "啊欧，服务不好使了，待会再试呗！";
        }

    }

}
