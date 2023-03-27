package com.qidi.bootdemo2.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 测试服务类的校验
 * <p>
 * 1. 只对mvc的方法有效，@controller类和@service类 详见{@link Validated} 注解
 * 2. 接口方法对参数添加 @Valid 注解（如果有分组，需要在接口方法上再添加 @Valided({group.class}) 注解实现类上添加 @Valided 注解
 *
 * @author maqidi
 * @date 2023/3/18 12:50 PM
 */

public interface ValidService {

    ResultResponse<String> checkParams(@Valid ParamQuery query);


    ResultResponse<String> checkParamsValid(@Min(value = 1, message = "仓库id最小值大于1") Long warehouseId);
}
