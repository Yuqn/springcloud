package com.yuqn.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TemplateConfig {
    /**
    * 定义一个模板对象
    * @LoadBalanced注解能够标记当前ResTempate使用负载均衡访问服务提供者，如果不加则不能获取服务
    */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
