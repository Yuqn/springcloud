package com.yuqn.hystrix;

import com.yuqn.service.TestService;
import org.springframework.stereotype.Component;

/**
* 熔断后回调事件，继承接口，并且批量处理
 * 注：使用该方法，接口每次添加方法，都必须在这里添加
*/
@Component
public class MyFallback implements TestService {
    @Override
    public String test() {
        return "熔断器熔断了";
    }

}
