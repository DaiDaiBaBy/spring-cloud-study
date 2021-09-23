package com.zhoufu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: zhoufu
 * @Date: 2021/7/5 18:01
 * @description:
 */
@RestController
@RequestMapping("/Hello")
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/Consumer")
    public String  helloWorld(String s){
        System.out.println("传入的值为： " +s);
        // 第一种调用方式
//        String forObject = new RestTemplate().getForObject("http://localhost:8071/Hello/World?s=" + s, String.class);

        // 第二种调用方式
        // 根据服务名  获取服务列表， 根据算法选取某个服务，并访问某个服务的网络位置
        ServiceInstance choose = loadBalancerClient.choose("EUREKA-SERVICE");
        String forObject = new RestTemplate().getForObject("http://" + choose.getHost() + ":" + choose.getPort() + "/Hello/World?s=" + s, String.class);

        // 第三中调用方式   需要 restTemplate注入的方式
//        String forObject = restTemplate.getForObject("http://EUREKA-SERVICE/Hello/World?s=" + s, String.class);
        return forObject;

        // 常用第三种调用方式
        /**
         * 第一种是直接调用：  不经过注册中心拿服务列表，  直接访问的servicesupport
         * 第二种，是根据服务名选择调用，  需注入 LoadBalancerClient, 用服务名去注册中心获取服务列表，当前客户端底层会做随机算法的选取获得服务并访问
         * 第三种。 需要一个@Bean的注解自动注入并直接调用restTemplate对象调用服务，   底层调用与第二种调用方式一样
         */
    }
}
