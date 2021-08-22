package com.springclouddemo.listener;

import com.springclouddemo.message.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *  不同group都可以获取消息 相同的group有集群和广播模式
 *  集群模式：相同group只有一个集群获取消息
 *  广播模式：相同group所有集群都可以获取消息
 */
@Component
public class DemoConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
    *消息的 Header 带有的 tag 值为 yunai 时，才进行消费。
     */
    @StreamListener(value = MySink.DEMO01_INPUT, condition = "headers['tag'] == 'yunai'")
    public void onMessage(@Payload DemoMessage message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }


}