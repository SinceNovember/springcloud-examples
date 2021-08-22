package com.springclouddemo.feign;

import com.springclouddemo.config.ProviderFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-provider", configuration = ProviderFeignClientConfiguration.class)
public interface ProviderFeignClient {

    @GetMapping("/echo")
    String echo(@RequestParam("name") String name);

}