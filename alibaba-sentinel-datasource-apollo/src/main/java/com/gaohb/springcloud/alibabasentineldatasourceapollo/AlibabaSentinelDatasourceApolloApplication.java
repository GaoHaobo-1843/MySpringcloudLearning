package com.gaohb.springcloud.alibabasentineldatasourceapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class AlibabaSentinelDatasourceApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelDatasourceApolloApplication.class, args);
    }

}
