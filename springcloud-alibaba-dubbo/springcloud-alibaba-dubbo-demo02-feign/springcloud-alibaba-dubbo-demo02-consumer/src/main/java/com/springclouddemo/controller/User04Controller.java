package com.springclouddemo.controller;

import com.springclouddemo.api.UserService;
import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 调用方式:Dubbo 最常用
 */
@RestController
@RequestMapping("/user04")
public class User04Controller {

    @Reference(version = "1.0.0", protocol = "dubbo")
    private UserService userService;

    @GetMapping("/get")
    public UserDTO get(@RequestParam("id") Integer id) {
        return userService.get(id);
    }

    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        return userService.add(addDTO);
    }

}