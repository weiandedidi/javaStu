package com.qidi.bootdemo2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author maqidi
 * @date 2023/3/18 12:57 PM
 */
@Service
@Validated
public class ValidServiceImpl implements ValidService {
    @Override
    public ResultResponse<String> checkParams(ParamQuery query) {
        ResultResponse response = ResultResponse.builder()
                .code(200)
                .message("success")
                .data("data")
                .build();
        return response;
    }

    @Override
    public ResultResponse<String> checkParamsValid(Long warehouseId) {
        ResultResponse response = ResultResponse.builder()
                .code(200)
                .message("success")
                .data("data")
                .build();
        return response;
    }
}
