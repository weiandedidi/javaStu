package com.qidi.bootdemo2.covert;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author qidi
 * @date 2019-01-31 18:20
 */
public class MapperTest {

    @Test
    public void testMapper() {
        Car car = new Car("3系", "宝马");
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println(carDto.getBrandDto());
    }


    @Test
    public void testListMapper() {
        Car car = new Car("3系", "宝马");

        List<CarDto> carDtos = CarMapper.INSTANCE.carsToCarDtoList(
                Lists.newArrayList(
                        new Car("3系", "宝马1"),
                        new Car("2系", "宝马2"))
        );
        System.out.println(carDtos.get(0).getBrandDto());
    }
}
