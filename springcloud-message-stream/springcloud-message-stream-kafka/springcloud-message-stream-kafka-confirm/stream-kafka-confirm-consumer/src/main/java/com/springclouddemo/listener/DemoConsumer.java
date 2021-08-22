package com.springclouddemo.listener;

import com.springclouddemo.message.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  不同group都可以获取消息 相同的group有集群和广播模式
 *  集群模式：相同group只有一个集群获取消息
 *  广播模式：相同group所有集群都可以获取消息
 */
@Component
public class DemoConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AtomicInteger index = new AtomicInteger();

    @StreamListener(MySink.DEMO01_INPUT)
    public void onMessage(@Payload DemoMessage message,
                          @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // 提交消费进度
//        if (message.getId() % 2 == 1) {
        //只提交一条消息，手动确认
        if (index.incrementAndGet() == 1) {
            acknowledgment.acknowledge();
        }
    }


}