package com.springclouddemo.feign;

import com.springclouddemo.feedback.ProviderFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "demo-provider", url = "http://127.0.0.1:8081",
        fallbackFactory = ProviderFeignClientFallbackFactory.class)
public interface ProviderFeignClient {

    @GetMapping("/demo/echo")
    String echo();

}