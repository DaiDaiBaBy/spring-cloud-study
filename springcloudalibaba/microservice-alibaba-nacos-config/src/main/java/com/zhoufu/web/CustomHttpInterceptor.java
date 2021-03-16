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
 * @Date: 2021/3/15 14:48
 * @description:  拦截处理类
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
        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++){
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // URL 参数
        queryString = queryString.equals("") ? null : queryString.substring(0, queryString.length() - 1);

        long end = System.currentTimeMillis();
        log.info("请求参数， url：{}， method: {}, query-params: {}, run-time: {}", url, method, queryString, (end-start));
        return true;
    }
}
