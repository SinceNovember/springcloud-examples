package com.springclouddemo.listener;

import com.rabbitmq.client.Channel;
import com.springclouddemo.message.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
                          @Header(AmqpHeaders.CHANNEL) Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // 提交消费进度
//        if (message.getId() % 2 == 1) {
        if (index.incrementAndGet() == 1) {
            // ack 确认消息
            // 第二个参数 multiple ，用于批量确认消息，为了减少网络流量，手动确认可以被批处。
            // 1. 当 multiple 为 true 时，则可以一次性确认 deliveryTag 小于等于传入值的所有消息
            // 2. 当 multiple 为 false 时，则只确认当前 deliveryTag 对应的消息
            channel.basicAck(deliveryTag, false);
        }
    }


}