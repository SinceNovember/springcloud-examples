package com.springclouddemo.listener;

import com.springclouddemo.message.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.context.IntegrationContextUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(MySink.DEMO01_INPUT) // 对应 DEMO-TOPIC-01.demo01-consumer-group-DEMO-TOPIC-01
    public void onMessage(@Payload DemoMessage message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
        throw new RuntimeException("我就是故意抛出一个异常");
    }

    @ServiceActivator(inputChannel = "DEMO-TOPIC-01.demo01-consumer-group-DEMO-TOPIC-01.errors")
    public void handleError(ErrorMessage errorMessage) {
        logger.error("[handleError][payload：{}]", errorMessage.getPayload().getMessage());
        logger.error("[handleError][originalMessage：{}]", errorMessage.getOriginalMessage());
        logger.error("[handleError][headers：{}]", errorMessage.getHeaders());
    }

    @StreamListener(IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME) // errorChannel
    public void globalHandleError(ErrorMessage errorMessage) {
        logger.error("[globalHandleError][payload：{}]", errorMessage.getPayload().getMessage());
        logger.error("[globalHandleError][originalMessage：{}]", errorMessage.getOriginalMessage());
        logger.error("[globalHandleError][headers：{}]", errorMessage.getHeaders());
    }

}