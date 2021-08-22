package com.springclouddemo.listener;

import com.springclouddemo.message.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  不同group都可以获取消息 相同的group有集群和广播模式
 *  集群模式：相同group只有一个集群获取消息
 *  广播模式：相同group所有集群都可以获取消息
 */
@Component
public class DemoConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(MySink.DEMO01_INPUT)
    public void onMessage(@Payload List<DemoMessage> message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }



}