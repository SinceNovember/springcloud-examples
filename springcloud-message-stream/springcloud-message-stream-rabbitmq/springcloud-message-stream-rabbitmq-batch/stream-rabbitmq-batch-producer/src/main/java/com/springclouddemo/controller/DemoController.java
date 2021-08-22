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

    @GetMapping("/send_batch")
    public boolean sendBatch() throws InterruptedException {
        // 发送 3 条消息，每条中间间隔 10 秒
        for (int i = 0; i < 3; i++) {
            // 创建 Message
            DemoMessage message = new DemoMessage()
                    .setId(new Random().nextInt());
            // 创建 Spring Message 对象
            Message<DemoMessage> springMessage = MessageBuilder.withPayload(message)
                    .build();
            // 发送消息
            mySource.demo01Output().send(springMessage);

            // 故意每条消息之间，隔离 10 秒
            logger.info("[sendBatch][发送编号：[{}] 发送成功]", message.getId());
            Thread.sleep(10 * 1000L);
        }
        return true;
    }

}