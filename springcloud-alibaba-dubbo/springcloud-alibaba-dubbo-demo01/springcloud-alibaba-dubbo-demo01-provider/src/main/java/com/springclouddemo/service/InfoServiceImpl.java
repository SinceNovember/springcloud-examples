package com.springclouddemo.service;

import com.springclouddemo.api.InfoService;
import com.springclouddemo.dto.InfoDTO;

@org.apache.dubbo.config.annotation.Service(protocol = "dubbo", version = "1.0.0")
public class InfoServiceImpl implements InfoService {
    @Override
    public InfoDTO get(Integer id) {
        return new InfoDTO().setId(id).setInfoName("没有信息");
    }
}
