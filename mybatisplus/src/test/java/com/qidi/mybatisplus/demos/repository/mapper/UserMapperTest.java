package com.qidi.mybatisplus.demos.repository.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidi.mybatisplus.demos.repository.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQuery() {
        System.out.println(userMapper.selectList(null));
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("三更草堂222");
        user.setPassword(7777);
        int r = userMapper.insert(user);
        System.out.println(r);
    }

    @Test
    public void testDelete() {
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        int i = userMapper.deleteBatchIds(ids);
        System.out.println(i);
    }

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(8);
        System.out.println(i);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.le("age", 13);
        List<User> userList = userMapper.selectList(query);
        System.out.println(userList);
    }

    /**
     * 1. yml中自定义的sql需要配置xml的位置
     * 2. 详见 mybatisplus/src/main/resources/mapper/UserMapper.xml
     */
    @Test
    public void testQueryCustomized() {
        UserCondition condition = UserCondition.builder()
                .minAge(14)
                .maxAge(25).build();
        List<User> userList = userMapper.selectByCondition(condition);
        System.out.println(userList);
    }

    /**
     * 分查询
     * 1. 定义com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor 拦截器bean
     * 2. 查询
     */
    @Test
    public void testPage(){
        IPage<User> page = new Page<>();
        //设置每页条数
        page.setSize(2);
        //设置查询第几页
        page.setCurrent(1);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());//获取当前页的数据
        System.out.println(page.getTotal());//获取总记录数
        System.out.println(page.getCurrent());//当前页码
    }
}