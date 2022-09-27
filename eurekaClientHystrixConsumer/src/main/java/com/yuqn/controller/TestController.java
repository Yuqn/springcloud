package com.yuqn.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yuqn.hystrix.MyHystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    // 测试异常熔断
    /**
     * @HystrixCommand 注解的作用是启动熔断机制，如果调用远程服务出现异常没响应，就会自动熔断
     * 属性 fallbackMethod 用于指定一个本地方法，用于熔断后返回信息，需要自定义
     */
    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test")
    public String test(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://eurekaClientProvider/go",String.class);
        System.out.println("服务消费者拿到服务提供者对象了===="+result);
        return "拥有熔断器的服务消费者";
    }

    // 测试超时熔断
    /**
     * @HystrixCommand 注解的作用是启动熔断机制，如果调用远程服务出现异常没响应，就会自动熔断
     * 属性
     *      fallbackMethod：用于指定一个本地方法，用于熔断后返回信息，需要自定义
     *      commandProperties：设置熔断器的一些属性
     *          execution.isolation.thread.timeoutInMilliseconds：熔断器超时时间
     *      ignoreExceptions： 指定跳过某些异常
     *          HttpServerErrorException.InternalServerError.class表示忽略服务提供者层的异常
     *          Exception.class表示忽略自身的异常
     */
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @RequestMapping("/timeout")
    public String timeout(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://eurekaClientProvider/timeout",String.class);
        System.out.println("服务消费者拿到服务提供者对象了===="+result);
        return "拥有熔断器的服务消费者";
    }

    // 测试自定义熔断器
    @RequestMapping("/customHystrix")
    public String customHystrix(){
        String url = "http://eurekaClientProvider/customHystrix";
        MyHystrixCommand command = new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),restTemplate,url);
        String body = (String) command.execute();
        return "拥有自定义熔断器的服务消费者"+body;
    }

    /**
    * 创建熔断方法
    */
    public String error(){
        return "熔断了";
    }
}
