package com.qidi.bootdemo2.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-12 10:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aoo implements Ioo {

    //姓名
    private String name;
    //年龄
    private int age;
}
