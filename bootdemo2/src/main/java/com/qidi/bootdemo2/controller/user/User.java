package com.qidi.bootdemo2.controller.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-07-09 15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //id
    private Long id;
    //名字
    private String name;
    //年龄
    private int age;
    //地址
    private String address;

}
