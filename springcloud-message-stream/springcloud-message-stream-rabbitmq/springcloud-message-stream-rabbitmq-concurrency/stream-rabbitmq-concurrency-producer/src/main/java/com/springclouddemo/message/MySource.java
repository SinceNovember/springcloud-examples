package com.springclouddemo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

    /*
    与配置文件里的bindings一致
     */
    @Output("demo01-output")
    MessageChannel demo01Output();

}