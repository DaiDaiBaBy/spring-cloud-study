package com.zhoufu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhoufu
 * @Date: 2021/7/5 16:48
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient  // 代表 是一个服务提供方
public class EurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
