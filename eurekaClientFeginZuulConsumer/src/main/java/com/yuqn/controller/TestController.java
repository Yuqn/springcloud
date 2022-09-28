package com.yuqn.controller;

import com.yuqn.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用feign 风格后，不需要创建 Template
 * 创建接口，执行流程如下：服务消费者访问接口方法 --> Spring通过接口代理到对应服务提供者 --> 访问到服务提供者，并且返回数据
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    /**
    * 无参方法
    */
    @RequestMapping("/test")
    public String test(){
        String result = testService.test();
        return "调用服务提供者返回"+result;
    }

}
