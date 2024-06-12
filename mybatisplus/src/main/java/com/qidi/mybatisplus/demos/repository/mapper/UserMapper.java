package com.qidi.mybatisplus.demos.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidi.mybatisplus.demos.repository.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author maqidi
 * @version 1.0
 * @create 2024-06-07 20:48
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //自定义sql
    List<User> selectByCondition(UserCondition condition);
}
