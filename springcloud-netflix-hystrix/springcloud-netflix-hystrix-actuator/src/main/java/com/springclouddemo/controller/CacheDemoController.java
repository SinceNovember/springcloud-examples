package com.springclouddemo.controller;

import com.springclouddemo.service.CacheDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求缓存
 */
@RestController
@RequestMapping("/cache-demo")
public class CacheDemoController {

    @Autowired
    private CacheDemoService cacheDemoService;

    @GetMapping("/get_user")
    public String getUser(@RequestParam("id") Integer id) {
        String userA = cacheDemoService.getUser(id);
        String userB = cacheDemoService.getUser(id);
        String userC = cacheDemoService.getUser(id);
        return userC;
    }

    @GetMapping("/update_user")
    public String updateUser(@RequestParam("id") Integer id) {
        String userA = cacheDemoService.getUser(id);
        cacheDemoService.updateUser(
                id);
        String userC = cacheDemoService.getUser(id);
        return userC;
    }

}