package com.lin.missyou.code.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 将Interceptor 注册进spring中
 *
 * @author WeiMao
 * @create 2020-12-08 21:20
 */
@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor());
    }
}
