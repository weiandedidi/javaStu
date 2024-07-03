package com.qidi.bootdemo2.config;

import com.qidi.bootdemo2.utils.TraceThreadPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

/**
 * 配置一个带有traceId的线程池，底层是newFixedThreadPool的实现
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 10:17
 */
@Configuration
public class ThreadPoolConfig {
    @Bean
    public ExecutorService traceFixedThreadPool() {
        // 创建一个固定大小的线程池，cpu的2倍
        return TraceThreadPool.newFixedTraceThreadPool(4);
    }
}
