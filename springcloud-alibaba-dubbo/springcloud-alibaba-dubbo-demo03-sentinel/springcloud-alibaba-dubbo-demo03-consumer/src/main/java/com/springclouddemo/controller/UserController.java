package com.springclouddemo.controller;

import com.springclouddemo.api.UserService;
import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(protocol = "dubbo", version = "1.0.0")
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