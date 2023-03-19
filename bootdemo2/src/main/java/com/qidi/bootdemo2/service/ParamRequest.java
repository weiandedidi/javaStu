package com.qidi.bootdemo2.service;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author maqidi
 * @date 2023/3/18 12:51 PM
 */
@Data
public class ParamRequest {

    @Min(value = 1, message = "warehouseId需要大于1")
    private Long warehouseId;
    @NotBlank
    private String name;
    @NotEmpty
    private List<String> wmOrderIdList;
    @Valid
    @NotNull
    private Student student;


    @Data
    public static class Student {
        @NotBlank
        private String name;
        @Min(value = 1, message = "最小值为1")
        private Integer age;
    }
}
