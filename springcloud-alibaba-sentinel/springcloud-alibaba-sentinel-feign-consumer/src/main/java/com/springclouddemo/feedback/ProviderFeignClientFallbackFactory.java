package com.springclouddemo.feedback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderFeignClientFallbackFactory implements FallbackFactory<ProviderFeignClientFallback> {

    @Override
    public ProviderFeignClientFallback create(Throwable throwable) {
        // 可以给 DemoProviderFeignClientFallback 提供具体的 throwable 异常
        return new ProviderFeignClientFallback(throwable);
    }

}