package com.springclouddemo.controller;

import com.springclouddemo.dto.DemoDTO;
import com.springclouddemo.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/test_get_demo")
    public DemoDTO testGetDemo(@RequestParam("type") int type, DemoDTO demoDTO) {
        // 方式一
        if (type == 1) {
            return providerFeignClient.getDemo(demoDTO);
        } else if (type == 2) {
            return providerFeignClient.getDemo(demoDTO.getUsername(), demoDTO.getPassword());
        } else {
            // 方式三
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("username", demoDTO.getUsername());
            params.put("password", demoDTO.getPassword());
            return providerFeignClient.getDemo(params);
        }
    }

    @GetMapping("/test_post_demo")
    public DemoDTO testPostDemo(DemoDTO demoDTO) {
        return providerFeignClient.postDemo(demoDTO);
    }


}