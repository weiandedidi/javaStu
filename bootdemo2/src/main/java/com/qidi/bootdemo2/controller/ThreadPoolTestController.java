package com.qidi.bootdemo2.controller;

import com.google.common.collect.Lists;
import com.qidi.bootdemo2.service.*;
import com.qidi.bootdemo2.utils.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-01 10:19
 */
@RestController
@RequestMapping("/pool")
@Slf4j
public class ThreadPoolTestController {

    @Autowired
    TraceIdThreadTestServiceImpl traceIdThreadTestService;
    @Autowired
    DemoDomainService demoDomainService;

    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public Object testPool(String name) throws InterruptedException {
        //主线程，启用子线程，5个进行调用
        log.info("主线程名称：{}，TraceId：{}", Thread.currentThread().getName(), TraceIdUtil.getTraceId());
        //启动五个子线程，循环调用, 主线程睡2秒，用于查看子线程会不会出现替换traceId
        Thread.sleep(2000);
        traceIdThreadTestService.printLog(5);
        return "success";
    }

    @RequestMapping(value = "/log/demo", method = RequestMethod.POST)
    public ResultResponse<String> getDemoString(@RequestBody ParamRequest request) {
        System.out.println("===================");
        ParamQuery query = ParamQuery.ParamQueryCovert.INSTANCE.toParamQuery(request);
        return demoDomainService.getDemoString(query);
    }

}
