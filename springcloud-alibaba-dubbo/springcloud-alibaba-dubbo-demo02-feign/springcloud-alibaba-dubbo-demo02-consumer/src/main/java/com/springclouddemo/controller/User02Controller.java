package com.springclouddemo.controller;

import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import com.springclouddemo.feign.UserFeignClient02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 调用方式:Feign + Ribbon
 */
@RestController
@RequestMapping("/user02")
public class User02Controller {
    @Autowired
    private UserFeignClient02 userFeignClient;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        return userFeignClient.get(id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return userFeignClient.add(addDTO);
    }
}
