package com.yuqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//激活 EurekaClient
@EnableEurekaClient
//激活 Zuul 的支持
@EnableZuulProxy
@SpringBootApplication
public class EurekaClientFeginZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFeginZuulGatewayApplication.class, args);
    }

}
