package com.qidi.bootdemo2.utils;

import java.util.concurrent.*;

/**
 * 实现一个基于newFixedThreadPool的自定义线程池
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 09:57
 */
public class TraceThreadPool extends ThreadPoolExecutor {

    public TraceThreadPool(int nThreads) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        String traceId = TraceIdUtil.getTraceId();
        super.execute(new TraceRunnable(command, traceId));
    }

    @Override
    public <T> java.util.concurrent.Future<T> submit(Callable<T> task) {
        String traceId = TraceIdUtil.getTraceId();
        return super.submit(new TraceCallable<>(task, traceId));
    }

    @Override
    public java.util.concurrent.Future<?> submit(Runnable task) {
        String traceId = TraceIdUtil.getTraceId();
        return super.submit(new TraceRunnable(task, traceId));
    }

    @Override
    public <T> java.util.concurrent.Future<T> submit(Runnable task, T result) {
        String traceId = TraceIdUtil.getTraceId();
        return super.submit(new TraceRunnable(task, traceId), result);
    }

    public static ExecutorService newFixedTraceThreadPool(int nThreads) {
        return new TraceThreadPool(nThreads);
    }

}
