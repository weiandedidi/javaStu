package com.qidi.bootdemo2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志拦截器
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-05-14 20:11
 */
//@Aspect
//@Component// 让SpringBoot来识别
//@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.qidi.bootdemo2.controller.*(..))")//定义切点 表示注解加在哪里（添加全路径）
    public void PointCut() {

    }

    @Before("PointCut()")
    public void Before(JoinPoint joinPoint) {

        //通过反射机制获得切入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //获取在自定义的注解@Log()中的内容
//        Log annotation = method.getAnnotation(Log.class);
//        mylog.setOperationModel(annotation.operationModel());
//        mylog.setOperationDescribe(annotation.operationDescribe());
    }

    @Around("PointCut()")
    public Object Around(ProceedingJoinPoint point) throws Throwable {

        Object proceed = point.proceed();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //入参，返回结果
        Object object = point.proceed();
//        log.info("函数名: {}, 参数：{}, 返回值: {}", method.getName(), point.getArgs(), object);
        System.out.println("函数名：" + method.getName() + "参数");
        return proceed;
    }

}
