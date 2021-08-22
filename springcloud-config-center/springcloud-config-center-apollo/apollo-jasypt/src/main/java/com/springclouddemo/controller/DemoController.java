package com.springclouddemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     *Apollo客户端需要通过ENC()包裹才知道时加密的
     */
    @Value("${xxx-password:}")
    private String xxxPassword;

    @GetMapping("/test")
    public String test() {
        return xxxPassword;
    }

}