package com.springclouddemo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 服务 demo-provider 的 FeignClient 配置类
 */
public class ProviderFeignClientConfiguration {

    @Bean
    @Primary // 主 Bean
    public Logger.Level feignClientLoggerLevel() {
        return Logger.Level.FULL;
    }

}