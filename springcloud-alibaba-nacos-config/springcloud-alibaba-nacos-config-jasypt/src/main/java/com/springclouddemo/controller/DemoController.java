package com.springclouddemo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${xxx-password:}")
    private String xxxPassword;

    @GetMapping("/test")
    public String test() {
        return xxxPassword;
    }

}