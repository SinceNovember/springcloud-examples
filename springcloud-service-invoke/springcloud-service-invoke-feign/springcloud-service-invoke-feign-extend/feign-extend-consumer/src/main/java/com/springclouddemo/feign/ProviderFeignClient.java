package com.springclouddemo.feign;

import com.springclouddemo.ProviderService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-provider")
public interface ProviderFeignClient extends ProviderService {

//    @GetMapping("/echo")
//    String echo(@RequestParam("name") String name);

}