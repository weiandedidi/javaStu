package com.qidi.bootdemo2.utils;

import java.util.UUID;

/**
 * springWebMVC的traceId工具类
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 09:41
 */
public class TraceIdUtil {
    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

    public static String generateTraceId() {
        return UUID.randomUUID().toString();
    }

    /**
     * 设置traceId
     *
     * @param traceId
     */
    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static void clear() {
        TRACE_ID.remove();
    }
}
