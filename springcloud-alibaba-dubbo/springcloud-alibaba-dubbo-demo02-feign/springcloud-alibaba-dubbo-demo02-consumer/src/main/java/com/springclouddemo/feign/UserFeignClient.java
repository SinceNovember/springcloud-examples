package com.springclouddemo.feign;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.springclouddemo.dto.UserAddDTO;
import com.springclouddemo.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务调用方式：Feign + Dubbo
 * 底层实际使用 Dubbo 来调用服务
 */
@FeignClient(name = "demo-provider")
@DubboTransported(protocol = "dubbo")
// @DubboTransported(protocol = "rest")
public interface UserFeignClient {

    /**
     * 根据指定用户编号，获得用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    @GetMapping("/user/get")
    UserDTO get(@RequestParam("id") Integer id);

    /**
     * 添加新用户，返回新添加的用户编号
     *
     * @param addDTO 添加的用户信息
     * @return 用户编号
     */
    @PostMapping("/user/add")
    Integer add(@RequestBody UserAddDTO addDTO);

}