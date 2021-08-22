package com.springclouddemo.service;

import com.springclouddemo.api.UserService;
import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import org.springframework.http.MediaType;

import javax.ws.rs.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


/**
 * Rest提供方式
 * 接入 Dubbo rest:// 协议来提供 HTTP 接口
 */
@org.apache.dubbo.config.annotation.Service(version = "1.0.0", protocol = {"dubbo", "rest"})
@Path("/user")
public class UserServiceImpl implements UserService {

    @Override
    @GET
    @Path("/get")
    @Produces(APPLICATION_JSON_VALUE)
    public UserDTO  get(@QueryParam("id") Integer id) {
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                .setGender(id % 2 + 1); // 1 - 男；2 - 女
    }

    @Override
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public Integer add(UserAddDTO addDTO) {
        return (int) (System.currentTimeMillis() / 1000); // 嘿嘿，随便返回一个 id
    }

}