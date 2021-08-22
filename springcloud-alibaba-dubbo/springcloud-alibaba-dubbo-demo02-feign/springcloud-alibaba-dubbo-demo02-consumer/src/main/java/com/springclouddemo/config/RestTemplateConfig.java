package com.springclouddemo.config;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 添加了 @DubboTransported 注解，这样 RestTemplate 调用服务时
     * 底层也变成了是使用 Dubbo 进行调用服务，也就是说 RestTemplate 变成了 DubboTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    @DubboTransported(protocol = "dubbo")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}