package com.springclouddemo.controller;

import com.springclouddemo.config.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * zookeeper文件创建路径为：/{root}/{spring.application.name},{profile}/
 *                         /config/demo-application,dev/server.port <<<<创建dev环境的配置文件 里面创建server.port配置
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private OrderProperties orderProperties;

    /**
     * 测试 @ConfigurationProperties 注解的配置属性类
     */
    @GetMapping("/test01")
    public OrderProperties test01() {
        return orderProperties;
    }

    @Value(value = "${order.pay-timeout-seconds}") // @NacosValue(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;
    @Value(value = "${order.create-frequency-seconds}") // @NacosValue(value = "${order.create-frequency-seconds}")
    private Integer createFrequencySeconds;

    /**
     * 测试 @Value 注解的属性
     */
    @GetMapping("/test02")
    public Map<String, Object> test02() {
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("payTimeoutSeconds", payTimeoutSeconds);
        results.put("createFrequencySeconds", createFrequencySeconds);
        return results;
    }

}