package com.qidi.bootdemo2.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qidi
 * @date 2019-09-18 18:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloImplTest {

    @Autowired
    HelloService hello;

    @Test
    public void sayHi() throws InterruptedException {
        hello.sayHi();
        System.out.println("我是hi之后的语句");
    }

    @Test
    public void hiAndCall() throws InterruptedException {
        hello.hiAndCall();
    }
}