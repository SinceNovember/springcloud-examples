package com.springclouddemo.web;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.security.BlockedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice(basePackages = "com.springclouddemo")
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BlockException.class)
    public JSONObject blockExceptionHandler(BlockException blockException) {
        return new JSONObject().fluentPut("code", 1024)
                .fluentPut("msg", "请求被拦截，拦截类型为 " + blockException.getClass().getSimpleName());
    }}
