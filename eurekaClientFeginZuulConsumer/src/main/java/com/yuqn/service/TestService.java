package com.yuqn.service;

import com.yuqn.hystrix.MyFallback;
import com.yuqn.hystrix.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @FeignClient 注解用于标记当前接口是一个Feign的声明式服务接口
 * Spring 会为这个接口生成动态代理对象
 * 属性
 *  name：表示服务提供者某个服务的名称
 *  fallback：熔断回调事件，fallbackFactory一样，只是自定义类不一样
*/
@FeignClient(name="eurekaClientProvider",fallbackFactory = MyFallbackFactory.class)
public interface TestService {
    /**
    * 定义方法要使用RequestMapping标记这个方法用于访问提供者
    * 其中RequestMapping的参数 /test 应该与当前接口所标记的服务名称某个路径相同
    */
    @RequestMapping("/test")
    String test();
}
