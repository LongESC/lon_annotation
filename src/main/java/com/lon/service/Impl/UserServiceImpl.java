package com.lon.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lon.entity.User;
import com.lon.mapper.UserMapper;
import com.lon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: lon_v3
 * @package: com.lon.lon_v3.service.Impl
 * @className: UserServiceImpl
 * @author: LONZT
 * @description: TODO
 * @date: 2023/5/9 14:48
 * @version: 1.0
 */

@Service
//@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    public UserMapper userMapper;

//    Page<User> page =new Page<>();


    @Override
    public Page<User> findUsersByName(String name,Page page) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        Page<User> usersByName = userMapper.selectPage(page,queryWrapper);
        return usersByName;
    }
}
