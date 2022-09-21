package com.yuqn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TextController {

    @RequestMapping("/text1")
    public String text(){
        // 连接消息提供者
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8080/text",String.class);
        System.out.println("result结果:"+result.getBody());
        return "这是消费者";
    }
}
