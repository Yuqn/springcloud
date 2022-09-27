package com.yuqn.hystrix;

import org.springframework.web.client.RestTemplate;

/**
* 自定义异常熔断器类，需继承 Hystrix 异常熔断器父类（抽象类）
*/
public class MyHystrixCommand extends com.netflix.hystrix.HystrixCommand {

    private RestTemplate restTemplate;
    private String url;
    /**
    * 定义有参构造参数，因为父类没有无参构造器
    */
    public MyHystrixCommand(Setter setter, RestTemplate restTemplate,String url){
        super(setter);
        this.restTemplate = restTemplate;
        this.url = url;
    }
    /**
    * spring 会自动调用这个方法来调用远程服务提供者
    */
    @Override
    protected Object run() throws Exception {
        return restTemplate.getForObject(url,String.class);
    }
    /**
    * 服务降级方法，当 spring 调用 run 方法后，如果服务出现异常则自动调用这个服务降级方法来进行异常的熔断
    */
    @Override
    protected Object getFallback(){
        System.out.println(super.getFailedExecutionException().getClass());
        System.out.println(super.getFailedExecutionException().getMessage());
        return "自定义异常类熔断器熔断了服务";
    }
}
