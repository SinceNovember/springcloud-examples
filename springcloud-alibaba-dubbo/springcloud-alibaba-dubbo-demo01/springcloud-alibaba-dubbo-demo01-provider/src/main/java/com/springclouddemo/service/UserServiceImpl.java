package com.springclouddemo.service;

import com.springclouddemo.api.UserService;
import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;

@org.apache.dubbo.config.annotation.Service(protocol = "dubbo", version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO get(Integer id) {
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1); // 1 - 男；2 - 女
    }

    @Override
    public Integer add(UserAddDTO addDTO) {
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }

}