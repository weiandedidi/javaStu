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
     * 线程池的定义，自定义的线程池
     */
    @Autowired
    private ExecutorService traceThreadPool;

    /**
     * 测试线程池
     */
    public void printLog(String name) {

        //启动printThreadCount个线程打印
        for (int i = 0; i < 5; i++) {
            traceThreadPool.submit(() -> printLogCase(name));
        }
    }

    private void printLogCase(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("线程名称：{}，name: {}, TraceId：{}", Thread.currentThread().getName(), name, TraceIdUtil.getTraceId());
    }
}
