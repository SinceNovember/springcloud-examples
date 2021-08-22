package com.springclouddemo.controller;

import com.springclouddemo.api.InfoService;
import com.springclouddemo.api.UserService;
import com.springclouddemo.dto.InfoDTO;
import com.springclouddemo.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Reference(protocol = "dubbo", version = "1.0.0")
    private InfoService infoService;

    @GetMapping("/get")
    public InfoDTO get(@RequestParam("id") Integer id) {
        return infoService.get(id);
    }
}
