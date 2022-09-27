package com.yuqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//激活eureka服务提供者
@EnableEurekaClient
// 激活声明式服务消费者Feign的支持
@EnableFeignClients
public class EurekaClientFeginConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFeginConsumerApplication.class, args);
    }

}
