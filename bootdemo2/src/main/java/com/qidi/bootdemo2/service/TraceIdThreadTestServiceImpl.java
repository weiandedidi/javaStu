package com.qidi.bootdemo2.service;

import com.qidi.bootdemo2.utils.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 10:21
 */
@Service
@Slf4j
public class TraceIdThreadTestServiceImpl {
    /**
     * 线程池的定义，源自方法com.qidi.bootdemo2.config.ThreadPoolConfig#traceFixedThreadPool()，使用自定义的线程池，线程池名称为traceFixedThreadPool
     */
    @Autowired
    private ExecutorService traceFixedThreadPool;

    /**
     * 测试线程池
     *
     * @param printThreadCount 线程池中启动的线程数
     */
    public void printLog(int printThreadCount) {

        //启动printThreadCount个线程打印
        for (int i = 0; i < 5; i++) {
            traceFixedThreadPool.submit(this::printLogCase);
        }
    }

    private void printLogCase() {
        log.info("线程名称：{}，TraceId：{}", Thread.currentThread().getName(), TraceIdUtil.getTraceId());
    }
}
