package com.yuqn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /**
    * 无参方法
    */
    @RequestMapping("/test")
    public String test(){
        return "使用Feign的服务提供者";
    }
}
