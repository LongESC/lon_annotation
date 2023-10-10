package com.lon.comomon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: lon_annotation
 * @package: com.lon.comomon
 * @className: AuthException
 * @author: LONZT
 * @description: TODO
 * @date: 2023/9/19 14:46
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthException extends RuntimeException {
    private int code=1005;
    private String msg;
}
