package com.yuqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//激活eureka服务提供者
@EnableEurekaClient
//激活Hystrix熔断机制
@EnableCircuitBreaker
public class EurekaClientHystrixConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientHystrixConsumerApplication.class, args);
    }

}
