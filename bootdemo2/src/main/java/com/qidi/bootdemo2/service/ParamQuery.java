package com.qidi.bootdemo2.service;

import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author maqidi
 * @date 2023/3/18 12:51 PM
 */
@Data
public class ParamQuery {

    @Min(value = 1, message = "warehouseId需要大于1")
    private Long warehouseId;
    @NotBlank
    private String name;
    @NotEmpty
    private List<String> wmOrderIdList;

    @Mapper
    public interface ParamQueryCovert {
        ParamQueryCovert INSTANCE = Mappers.getMapper(ParamQueryCovert.class);

        ParamQuery toParamQuery(ParamRequest request);
    }
}
