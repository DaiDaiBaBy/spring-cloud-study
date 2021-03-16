package com.zhoufu.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: zhoufu
 * @Date: 2021/3/15 14:14
 * @description:  拦截器定义
 */
@Configuration
public class WebConfig  extends WebMvcConfigurationSupport{
    /**
     *  提前加载bean ，让拦截器中的 @Autowired生效
     */
    @Bean
    public HandlerInterceptor getInterceptor(){
        return new CustomHttpInterceptor();
    }


    /**
     * 可 定义多个拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 定义过滤拦截的url名称， 拦截所有请求
        registry.addInterceptor(this.getInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决 swagger-ui.html 404错误
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        // 解决 doc.html  404错误
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }
}
