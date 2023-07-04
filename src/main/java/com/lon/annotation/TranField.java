package com.lon.annotation;

import java.lang.annotation.*;

/**
 * @projectName: lon_annotation
 * @package: com.lon.annotation
 * @className: TranField
 * @author: LONZT
 * @description: TODO
 * @date: 2023/6/26 9:07
 * @version: 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TranField {


    /**
     * 获取翻译类型
     *
     * @return 类型
     */
    String type();

    String tableName() default "";

    String tableField() default "";

    String tableMapField() default "";

}
