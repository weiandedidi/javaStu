package com.qidi.bootdemo2.covert;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 设置组件模型为Spring
 *
 * @author qidi
 * @date 2019-01-31 16:25
 */

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mappings({
            @Mapping(source = "model", target = "modelDto"),
            @Mapping(source = "brand", target = "brandDto")
    })
    CarDto carToCarDto(Car car);

    List<CarDto> carsToCarDtoList(List<Car> cars);

}
