package com.springclouddemo.feedback;

import com.springclouddemo.feign.ProviderFeignClient;
import org.springframework.stereotype.Component;

public class ProviderFeignClientFallback implements ProviderFeignClient {

    private Throwable throwable;

    public ProviderFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo() {
        return "fallback:" + throwable.getClass().getSimpleName();
    }

}