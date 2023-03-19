package com.qidi.bootdemo2.controller;

import com.google.common.collect.Lists;
import com.qidi.bootdemo2.service.ParamQuery;
import com.qidi.bootdemo2.service.ParamRequest;
import com.qidi.bootdemo2.service.ParamResponse;
import com.qidi.bootdemo2.service.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 测试参数校验
 *
 * @author maqidi
 * @date 2023/3/18 12:59 PM
 */
@RestController
@RequestMapping("/test")
@Component
public class TestController {

    @Autowired
    ValidService validService;


    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ParamResponse<String> checkParams(@RequestBody ParamRequest request) {
        System.out.println("===================");
//        ParamQuery query = ParamQuery.ParamQueryCovert.INSTANCE.toParamQuery(request);
        ParamQuery query = new ParamQuery();
        query.setName(null);
        query.setWarehouseId(0L);
        query.setWmOrderIdList(Lists.newArrayList());
        return validService.checkParams(query);
    }

    @RequestMapping(value = "/checkV2", method = RequestMethod.GET)
    public String checkParams(@Min(value = 1, message = "参数需要大于2") Long id) {
        System.out.println("===================V2");
        return "success";
    }

    @RequestMapping(value = "/checkV3", method = RequestMethod.GET)
    public ParamResponse<String> checkResponse(Long id) {
        System.out.println("===================V3");
        ParamResponse<String> response = new ParamResponse();
        return response;
    }
}
