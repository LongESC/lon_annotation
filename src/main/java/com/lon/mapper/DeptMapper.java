package com.lon.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lon.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lon
 * @since 2023-03-09
 */
@Repository
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {



}
