package com.gaohb.springcloud.alibabanacosconfigclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
public class TestController {

    @Value("${gaohb.title:}")
    private String title;

    @Value("${gaohb.example:}")
    private String example;

    @GetMapping("/example")
    public String example() {
        return example;
    }

    @GetMapping("/test")
    public String hello() {
        return title;
    }
}
