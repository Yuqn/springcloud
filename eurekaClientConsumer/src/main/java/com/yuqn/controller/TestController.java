package com.yuqn.controller;

import com.yuqn.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    // 获取服务提供者的返回的对象,将原本对象转为 stirng 类型，可以手动创建 user 实体类接收，如 User.class
    @RequestMapping("/getUser")
    public String getUser(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://eurekaClientProvider/getUser",String.class);
        return result.getBody();
    }

    // 调用有参数服务，需要设置参数
    @RequestMapping("/getUserForParams")
    public String getUserForParams(){
        // 创建条件构造器
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userName","yuqn");
        params.put("userAge",21);
        params.put("userSex","男");

        // 将条件构造器存在第三个参数中
        ResponseEntity<String> result = restTemplate.getForEntity("http://eurekaClientProvider/getForParams?userName={userName}",String.class,params);
        return "消费者调用提供者的结果"+result.getBody();
    }

    // ================================================
    // post 方法传递,使用linkedMultiValueMap对象保存传递的参数
    @RequestMapping("/postForObject")
    public String postForObject(){
        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.add("userName","yuqn");
        params.add("userAge",22);
        String str = "http://eurekaClientProvider/postForParams";
        User user = restTemplate.postForObject(str,params,User.class);
        return "服务消费者"+user;
    }
    // put 对应的服务提供者为 put ，没有返回值
    // delete 对应的服务提供者为 delete

}
