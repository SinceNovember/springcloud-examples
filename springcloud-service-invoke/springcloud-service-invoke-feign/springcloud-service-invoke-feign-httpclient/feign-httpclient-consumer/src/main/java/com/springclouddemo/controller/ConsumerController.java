package com.springclouddemo.controller;

import com.springclouddemo.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/hello02")
    public String hello02(String name) {
        // 使用 Feign 调用接口
        String response = providerFeignClient.echo(name);
        // 返回结果
        return "consumer:" + response;
    }

}