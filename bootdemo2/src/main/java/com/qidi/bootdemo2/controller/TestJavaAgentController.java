package com.qidi.bootdemo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试javaAgent探针篡改的类
 * 详见这个文档：https://blog.csdn.net/qq_36370910/article/details/130562385
 * 本质修改agent然后替换文件。
 *
 * 加载时修改vm参数，找到test-agent.jar包的位置
 * -javaagent:.../javaagent/JavaAgent/target/test-agent.jar
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-04-12 16:52
 */
@RestController
@RequestMapping("/agent")
public class TestJavaAgentController {

    String text = "这里是正确数据";

    /**
     * 测试被agent修改的代码
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testAgent() {
        System.out.println("这里会被agent插入代码");
        return text;
    }

    /**
     * 测试被agent修改的代码
     *
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        System.out.println("我是原始的方法hi");
        return text;
    }
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initText() {
        text = "初始化为原来数据";
        return text;
    }


}
