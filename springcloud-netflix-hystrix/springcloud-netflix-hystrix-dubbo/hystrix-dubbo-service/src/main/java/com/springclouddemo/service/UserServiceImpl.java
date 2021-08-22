package com.springclouddemo.service;

import com.springclouddemo.UserService;

@org.apache.dubbo.config.annotation.Service(protocol = "dubbo", version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public String getUser(Integer id) {
        return "User:" + id;
    }

}