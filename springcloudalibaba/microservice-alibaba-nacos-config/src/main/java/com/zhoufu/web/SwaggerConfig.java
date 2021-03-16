package com.zhoufu.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhoufu
 * @Date: 2021/3/15 14:56
 * @description:   swagger在线接口插件配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 创建一个Docket对象 调用select()方法， 生成ApiSelectorBuilder对象实例，该对象负责定义外漏的API入口
     * 通过使用RequestHandlerSelectors和PathSelectors来提供Predicate，在此我们使用any()方法，将所有API都通过Swagger进行文档管理
     * @return
     */
    @Bean
    public Docket createRestApi(){
        ParameterBuilder useridPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        useridPar.name("access_token").defaultValue("").description("访问身份令牌").modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        pars.add(useridPar.build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 如果不想将所有的接口都通过swagger管理的话，可以将RequestHandlerSelectors.any()修改为RequestHandlerSelectors.basePackage()
                // .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.zhoufu"))  // 配置扫描的控制器类包
                .paths(PathSelectors.any()) //配置符合指定规则的路径接口才生成在线接口，用于定制那些接口在ui中展示
                .build()
                .globalOperationParameters(pars);
    }

    @SuppressWarnings("deprecation")
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 标题
                .title("在线接口测试平台：microservice-alibaba-nacos-config服务")
                // 简介
                .description("rest接口层：接口服务")
                // 服务条款
                .termsOfServiceUrl("https://baidu.com")
                // 作者个人信息
                .contact("zhoufu")
                // 版本
                .version("1.0").build();
    }
}
