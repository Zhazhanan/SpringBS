package org.huha.bsresponsewrap.demo.config;

import org.huha.bsresponsewrap.module.aspect.RestControllerAspect;
import org.huha.bsresponsewrap.module.handler.ResponseResultHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangKun
 * @create 2019-01-03
 * @desc
 **/
@Configuration
public class BeanConfig {

    /**
     * @methodName:
     * @param:
     * @describe: 请求参数、响应体统一日志打印
     * @auther: WangKun
     * @date: 2019-01-03
     * @time: 下午 12:56
     **/
    @Bean
    public RestControllerAspect restControllerAspect() {
        return new RestControllerAspect();
    }

}
