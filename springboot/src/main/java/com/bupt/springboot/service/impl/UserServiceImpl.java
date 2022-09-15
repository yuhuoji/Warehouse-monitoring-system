package com.bupt.springboot.service.impl;

/* Service层 */
/* B层：针对具体问题的操作，主要从界面和数据库中得到数据，对数据进行逻辑处理。比如验证，计算，业务规则 */
/* Service层的具体实现 Service(BLL)业务逻辑服务层*/

import com.bupt.springboot.entity.User;
import com.bupt.springboot.mapper.UserMapper;
import com.bupt.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    /* Service层调用Mapper层 */
    private UserMapper userMapper;

    /* 业务层具体实现方法 */
/*    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    *//* 用mybatisPlus的QueryWrapper判断是否在数据库里*//*
    User one = userMapper.getOne(new QueryWrapper<User>()
            .eq("username", user.getUsername())
            .eq("password", user.getPassword())

    );*/


    /* 具体实现service接口 */
    @Override
    public List<User> login() {
        return userMapper.login();
    }

}
