package com.zhoufu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhoufu
 * @Date: 2021/3/15 14:30
 * @description:
 */
@RestController
@Slf4j
@Api(tags = { "init" })
public class InitController {

    @ApiOperation(value = "欢迎入口", httpMethod = "GET")
    @GetMapping("/hello")
    public String hello(){
        log.info("【microservice-alibaba-nacos-discovery】");
        return "Hello, greeting from microservice-alibaba-nacos-discovery";
    }
}
