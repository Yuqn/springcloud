package com.yuqn.hystrix;

import com.yuqn.service.TestService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断后回调事件，公共降级
 */
@Component
public class MyFallbackFactory implements FallbackFactory<TestService> {
    /**
    * 使用匿名内部类来创建声明式接口熔断对象
    */
    @Override
    public TestService create(Throwable cause) {
        return new TestService() {
            @Override
            public String test() {
                return "方法被熔断了";
            }

            @Override
            public String test1(String id, String name) {
                return null;
            }
        };
    }
}
