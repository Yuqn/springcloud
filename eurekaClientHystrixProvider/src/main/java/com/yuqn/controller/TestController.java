package com.yuqn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    /**
    * 异常熔断
     */
    @GetMapping("/go")
    public String test(){
        int a = 12/0;
        return "提供服务";
    }
    /**
     * 超时熔断
     */
    @GetMapping("/timeout")
    public String timeout(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "提供服务";
    }
    /**
     * 测试自定义熔断器
     */
    @GetMapping("/customHystrix")
    public String customHystrix(){
        System.out.println(10/0);
        return "提供服务";
    }
}
