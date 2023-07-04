package com.lon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lon.comomon.RedisConstant;
import com.lon.entity.Dept;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

/**
 * @projectName: lon_v3
 * @package: com.lon.lon_v3.service
 * @className: DeptService
 * @author: LONZT
 * @description: TODO
 * @date: 2023/6/14 15:50
 * @version: 1.0
 */
public interface DeptService extends IService<Dept> {


}
