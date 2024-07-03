package com.qidi.bootdemo2.aspect;

import com.google.gson.Gson;
import com.qidi.bootdemo2.utils.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 写一个traceId的拦截器，用于打印指定日志的格式形式
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 11:30
 */
@Aspect
@Component// 让SpringBoot来识别
@Slf4j
public class TraceLogAspect {
    @Around("@annotation(traceLog)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, TraceLog traceLog) {
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = traceLog.value().name();

        String traceId = TraceIdUtil.getTraceId();
        Gson gson = new Gson();
        String paramsJson = gson.toJson(joinPoint.getArgs());

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("TraceId: {} - Method: {} - Exception: {}", traceId, methodName, throwable.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - start;
            //这个即使为null，也会打印
            String resultJson = gson.toJson(result);
            //打印入参和出参
            log.info("TraceId: {} - Method: {} - Execution time: {} ms - Params: {} - Result: {} - ", traceId, methodName, executionTime, paramsJson, resultJson);
        }

        return result;
    }
}
