package com.lon.mapper;

/**
 * @projectName: lon_v3
 * @package: com.lon.lon_v3.mapper
 * @className: SqlMapper
 * @author: LONZT
 * @description: TODO
 * @date: 2023/5/9 10:50
 * @version: 1.0
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lon.comomon.Result;
import com.lon.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Admin
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> findUsersByName(String name,Page page);

}

