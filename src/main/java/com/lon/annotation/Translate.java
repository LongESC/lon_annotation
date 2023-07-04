package com.lon.annotation;

import java.lang.annotation.*;

/**
 * @projectName: lon_annotation
 * @package: com.lon.annotation
 * @className: Translate
 * @author: LONZT
 * @description: TODO
 * @date: 2023/6/26 9:05
 * @version: 1.0
 */

@Documented
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME )
public @interface Translate {
   String target();
}
