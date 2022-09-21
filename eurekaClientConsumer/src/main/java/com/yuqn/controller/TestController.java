package com.yuqn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        // ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8081/go",String.class);
        ResponseEntity<String> result = restTemplate.getForEntity("http://eurekaClientProvider/go",String.class);
        System.out.println("服务消费者拿到服务提供者对象了===="+result);
        return "服务消费者";
    }
}
