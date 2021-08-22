package com.springclouddemo.controller;

import com.springclouddemo.message.DemoMessage;
import com.springclouddemo.message.MySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
@RequestMapping("/demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MySource mySource;

    @GetMapping("/send_delay")
    public boolean sendDelay() {
        // 创建 Message
        DemoMessage message = new DemoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<DemoMessage> springMessage = MessageBuilder.withPayload(message)
                .setHeader("x-delay", 5000) // 设置延迟时间，单位：毫秒
                .build();
        // 发送消息
        boolean sendResult = mySource.demo01Output().send(springMessage);
        logger.info("[sendDelay][发送消息完成, 结果 = {}]", sendResult);
        return sendResult;
    }


}