package com.lon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lon.comomon.RedisConstant;
import com.lon.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

/**
 * @projectName: lon_v3
 * @package: com.lon.lon_v3.service
 * @className: UserService
 * @author: LONZT
 * @description: TODO
 * @date: 2023/5/9 14:48
 * @version: 1.0
 */
public interface UserService extends IService<User> {



    Page<User> findUsersByName(String name, Page page);
}
