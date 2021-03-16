package com.zhoufu.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: zhoufu
 * @Date: 2021/3/16 13:52
 * @description:   拦截器
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 提前加载bean，  先让拦截器中的@Autowired生效
     * @return
     */
    @Bean
    public HandlerInterceptor getInterceptor(){
        return new CustomHttpInterceptor();
    }

    /**
     * 定义多个拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有的请求
        registry.addInterceptor(this.getInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     *  解决  swagger2 的页面404 问题
     *  swagger-ui.html    doc.html等页面
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }
}
