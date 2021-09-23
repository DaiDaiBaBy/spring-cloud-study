package com.zhoufu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhoufu
 * @Date: 2021/7/5 17:59
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient  //  当前使用eureka 的 server
public class EurekaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}
