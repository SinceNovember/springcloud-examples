package com.springclouddemo.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

    /**
     * 对应配置配置文件中的bindings下的
     */
    String DEMO01_INPUT = "demo01-input";

    @Input(DEMO01_INPUT)
    SubscribableChannel demo01Input();

}