package com.qidi.mybatisplus.demos.repository.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * mybatis-plus自定义的condition，用于展示xml编写sql
 *
 * @author maqidi
 * @version 1.0
 * @create 2024-06-12 17:10
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UserCondition {
    /**
     * 查找id集合
     */
    private List<Integer> ids;
    /**
     * 名字
     */
    private String name;
    /**
     * 最小年龄
     */
    private Integer minAge;
    /**
     * 最大年龄
     */
    private Integer maxAge;
}
