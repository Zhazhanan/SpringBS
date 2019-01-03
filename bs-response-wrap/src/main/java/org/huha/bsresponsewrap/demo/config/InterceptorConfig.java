package org.huha.bsresponsewrap.demo.config;

import org.huha.bsresponsewrap.module.interceptor.LoginAuthInterceptor;
import org.huha.bsresponsewrap.module.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WangKun
 * @create 2018-12-21
 * @desc
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Bean
    public LoginAuthInterceptor loginAuthInterceptor() {
        return new LoginAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        // 响应结果控制拦截
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns(apiUri);
        // 登录拦截
        registry.addInterceptor(loginAuthInterceptor()).addPathPatterns(apiUri);
    }
}
