package com.qidi.mybatisplus.demos.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-06-07 20:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private Integer password;
    private String  name;
    private Integer age;
    private String address;

}
