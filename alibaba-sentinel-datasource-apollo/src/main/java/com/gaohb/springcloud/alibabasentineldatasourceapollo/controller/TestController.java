package com.gaohb.springcloud.alibabasentineldatasourceapollo.controller;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableApolloConfig
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello Gaohb!";
    }
}
