package com.qidi.bootdemo2.service;

import com.qidi.bootdemo2.aspect.MethodNameEnum;
import com.qidi.bootdemo2.aspect.TraceLog;
import org.springframework.stereotype.Service;

/**
 * 用于测试使用的domainService
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-07-03 14:05
 */
@Service
public class DemoDomainService {

    @TraceLog(MethodNameEnum.METHOD_DEMO)
    public ResultResponse<String> getDemoString(ParamQuery paramQuery) {
        ResultResponse response = ResultResponse.builder()
                .code(200)
                .message("success")
                .data("data")
                .build();
        return response;
    }

}
