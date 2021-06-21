package com.study.minio.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘祖鸿
 */
@Slf4j
public class TestFeignClientFallback implements FallbackFactory<TestFeignClient> {
    @Override
    public TestFeignClient create(Throwable throwable) {
        log.info("调用接口异常",throwable.getMessage());
        return null;
    }
}
