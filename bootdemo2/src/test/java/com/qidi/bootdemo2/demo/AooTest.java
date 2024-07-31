package com.qidi.bootdemo2.demo;

import com.qidi.bootdemo2.utils.GsonUtil;
import org.junit.Test;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-12 10:48
 */
public class AooTest {

    @Test
    public void testSuperJSON() {
        Ioo ioo = new Aoo("你好", 4);
        System.out.println(GsonUtil.toJsonString(ioo));
    }
}
