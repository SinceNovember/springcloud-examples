package com.springclouddemo.controller;

import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import com.springclouddemo.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 调用方式:Feign + Dubbo
 */
@RestController
@RequestMapping("/user01")
public class User01Controller {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        return userFeignClient.get(id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return userFeignClient.add(addDTO);
    }

}