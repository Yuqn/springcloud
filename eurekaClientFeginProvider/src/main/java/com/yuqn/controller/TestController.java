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
        System.out.println(10/0);
        return "使用Feign的服务提供者";
    }

    /**
     * 有参方法
     */
    @RequestMapping("/test1")
    public String test2(String id,String name){
        return "有参方法"+id+name;
    }
}
