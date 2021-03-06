package com.springclouddemo.feign;

import com.springclouddemo.fallback.UserServiceFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://127.0.0.1:18080", fallbackFactory = UserServiceFeignClientFallbackFactory.class)
public interface UserServiceFeignClient {

    @GetMapping("/user/get")
    String getUser(@RequestParam("id") Integer id);

}