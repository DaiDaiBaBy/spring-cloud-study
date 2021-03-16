package com.zhoufu.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: zhoufu
 * @Date: 2021/3/11 17:38
 * @description:  拦截处理类
 */

/**
 * RefreshScope(org.springframework.cloud.context.scope.refresh)
 *  是spring cloud提供的一种特殊的scope实现，用来实现配置、实例热加载
 *  解决资源文件与javaConfig的同步问题的
 */
@Component
@Slf4j
@RefreshScope
public class CustomHttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long start = System.currentTimeMillis();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String queryString = "";
        // 去掉最后一个空格
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] values = parameterMap.get(key);
            for (int i = 0; i < values.length; i ++){
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // URL参数
        queryString = queryString.equals("") ? null : queryString.substring(0, queryString.length() - 1);
        long end = System.currentTimeMillis();

        log.info(String.format("请求参数， url：{}, method: {}, queryParams: {}, run-time: {}", url, method, queryString, (end-start) + ""));
        return true;
    }
}
