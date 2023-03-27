package com.qidi.bootdemo2.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maqidi
 * @date 2023/3/18 12:54 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {

    private Integer code;
    private String message;

    private T data;
}
