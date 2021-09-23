package com.zhoufu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zhoufu
 * @Date: 2021/7/5 16:29
 * @description:
 */
@SpringBootApplication
@EnableEurekaServer  // 当前使用 eureka 的server
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
