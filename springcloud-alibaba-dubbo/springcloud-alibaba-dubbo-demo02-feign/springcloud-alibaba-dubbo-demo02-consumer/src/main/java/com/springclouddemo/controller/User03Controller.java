package com.springclouddemo.controller;

import com.alibaba.fastjson.JSON;
import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 调用方式:RestTemplate + Dubbo
 * 因为restTemplate添加了 @DubboTransported 注解，这样 RestTemplate 调用服务时，底层也变成了是使用 Dubbo 进行调用服务，也就是说 RestTemplate 变成了 DubboTemplate
 * 调用通过dubbo://协议
 * 需要引入dubbo-demo02-api 依赖
 */
@RestController
@RequestMapping("/user03")
public class User03Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        String url = String.format("http://%s/user/get?id=%d", "demo-provider", id);
        return restTemplate.getForObject(url, UserDTO.class);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 请求体
        String body = JSON.toJSONString(addDTO);
        // 创建 HttpEntity 对象
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        // 执行请求
        String url = String.format("http://%s/user/add", "demo-provider");
        return restTemplate.postForObject(url, entity, Integer.class);
    }

}