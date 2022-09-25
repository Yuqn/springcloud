package com.yuqn.controller;

import com.yuqn.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/go")
    public String test(){
        return "提供服务";
    }
    // 返回对象
    @GetMapping("/getUser")
    public User getUser(){
        return new User("yuqn",22,"男");
    }
    // 返回数组对象，被接收后，不会转为指定泛型，而是map类型
    @GetMapping("/getUserList")
    public List<User> getUserList(){
        User userOne = new User("yuqn",22,"男");
        User userTwo = new User("yuqn",22,"男");
        List<User> list = new ArrayList();
        list.add(userOne);
        list.add(userTwo);
        return list;
    }
    // 有参数情况
    @RequestMapping("/getForParams")
    public User getUserForParams(User user){
        user.setUserName(user.getUserName()+"new");
        return user;
    }
}
