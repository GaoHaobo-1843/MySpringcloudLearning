package com.gaohb.springcloud.alibabanacosdiscoveryclientcommon.controller;

import com.gaohb.springcloud.alibabanacosdiscoveryclientcommon.config.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private TestFeignClient client;

    @GetMapping("/testFeign")
    public String testFeign() {
        String result = client.hello("gaohb");
        return "Return : " + result;
    }

    /* original */
    @GetMapping("/test")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
        String url = serviceInstance.getUri() + "/hello?name=" + "gaohb";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

    /* RestTemplate */
    @GetMapping("/testRestTemplate")
    public String testRestTemplate() {
        String result = restTemplate.getForObject("http://alibaba-nacos-discovery-server/hello?name=gaohb", String.class);
        return "Return : " + result;
    }
    
    /* webClient */
    @GetMapping("/testWebClient")
    public Mono<String> testWebClient() {
        Mono<String> result = webClientBuilder.build()
                .get()
                .uri("http://alibaba-nacos-discovery-server/hello?name=gaohb")
                .retrieve()
                .bodyToMono(String.class);
        return result;
    }

    /* feign */

}
