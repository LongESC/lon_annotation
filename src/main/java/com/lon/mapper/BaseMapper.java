package com.lon.mapper;

import com.lon.comomon.RedisConstant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @projectName: lon_annotation
 * @package: com.lon.mapper
 * @className: BaseMapper
 * @author: LONZT
 * @description: TODO
 * @date: 2023/7/3 10:14
 * @version: 1.0
 */
@Repository
@Mapper
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {

    @Select("${nativeSql}")
    List<Map<String,Object>> nativeSql(@Param("nativeSql") String nativeSql);


    @Select("select ${field} from ${tableName} where ${condition}")
    List<Map<String,Object>> findFields(@Param("tableName") String tableName,
                                        @Param("field")String field,
                                        @Param("condition")String condition);
    @Cacheable(cacheNames = RedisConstant.CacheNames.CACHE_1_DAY)
    @Select("select ${field} from ${tableName} where ${condition}")
    String findField(@Param("tableName") String tableName,
                              @Param("field") String field,
                              @Param("condition") String condition) ;

    @CacheEvict(cacheNames = RedisConstant.CacheNames.CACHE_1_DAY)
    @Update("update md_user set dept=3002 where uno=710120220009")
    boolean updateZtl();


}
