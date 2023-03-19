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
    public ParamResponse<String> checkParams(ParamQuery query) {
        ParamResponse response = ParamResponse.builder()
                .code(200)
                .message("success")
                .data("data")
                .build();
        return response;
    }
}
