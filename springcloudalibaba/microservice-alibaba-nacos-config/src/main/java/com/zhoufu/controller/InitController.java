package com.zhoufu.controller;

import com.zhoufu.util.JsonResult;
import com.zhoufu.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhoufu
 * @Date: 2021/3/15 15:11
 * @description:
 */
@RestController
@Slf4j
@Api(tags = { "init"})
@RefreshScope   // @RefreshScope注解，支持实时修改配置值，而不需要重启项目
public class InitController {

    @Value("${config.appKey}")
    private String appKey;

    @ApiOperation(value = "欢迎入口", httpMethod = "GET")
    @GetMapping("/hello")
    public String hello(){
        log.info("【microservice-alibaba-nacos-config】");
        return "Hello, greetings from microservice-alibaba-nacos-config";
    }

    @ApiOperation(value = "获得AppKey值", httpMethod = "GET")
    @GetMapping("/getAppKey")
    public JsonResult getAppKey(){
        return new JsonResult(ResultCode.SUCCESS, this.appKey);
    }

}
