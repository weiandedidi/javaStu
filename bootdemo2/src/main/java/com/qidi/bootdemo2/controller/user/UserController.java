package com.qidi.bootdemo2.controller.user;

import com.qidi.bootdemo2.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-06-05 11:54
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/get")
    public String getUserById(Long id) {
        log.info("查找用户 {}", id);
        log.info("内容不正确用户 {}", id);
        log.info("这里编写点别的 {}", id);
        return "userA";
    }

    @RequestMapping("/set")
    public String setUser(String name) throws InterruptedException {
        log.info("测试用户的名字编写");
        log.info("新增语句");
        helloService.printString();
        return "userB";
    }
}
