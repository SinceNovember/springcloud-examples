package com.springclouddemo.controller;

import com.springclouddemo.message.DemoMessage;
import com.springclouddemo.message.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MySource mySource;

    @GetMapping("/send")
    public boolean send() {
        // 创建 Message
        DemoMessage message = new DemoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<DemoMessage> springMessage = MessageBuilder.withPayload(message)
                .build();
        // 发送消息
        return mySource.demo01Output().send(springMessage);
    }

    /**
     * 发送延迟消息
     * @return
     */
    @GetMapping("/send_delay")
    public boolean sendDelay() {
        // 创建 Message
        DemoMessage message = new DemoMessage()
                .setId(new Random().nextInt());
        // 创建 Spring Message 对象
        Message<DemoMessage> springMessage = MessageBuilder.withPayload(message)
                .setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, "3") // 设置延迟级别为 3，10 秒后消费。
                .build();
        // 发送消息
        boolean sendResult = mySource.demo01Output().send(springMessage);
        logger.info("[sendDelay][发送消息完成, 结果 = {}]", sendResult);
        return sendResult;
    }

    @GetMapping("/send_orderly")
    public boolean sendOrderly() {
        // 发送 3 条相同 id 的消息
        int id = new Random().nextInt();
        for (int i = 0; i < 3; i++) {
            // 创建 Message
            DemoMessage message = new DemoMessage().setId(id);
            // 创建 Spring Message 对象
            Message<DemoMessage> springMessage = MessageBuilder.withPayload(message)
                    .build();
            // 发送消息
            mySource.demo01Output().send(springMessage);
        }
        return true;
    }

}