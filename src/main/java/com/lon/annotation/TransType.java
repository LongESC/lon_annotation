package com.lon.annotation;

/**
 * @projectName: lon_annotation
 * @package: com.lon.annotation
 * @className: TransType
 * @author: LONZT
 * @description: TODO
 * @date: 2023/6/30 10:27
 * @version: 1.0
 */
public interface TransType {




    /**
     * 自动翻译
     */
    String AUTO_TRANS = "auto";

    /**
     * 字典
     */
    String DICTIONARY = "dictionary";

    /**
     * 简单翻译
     */
    String SIMPLE = "simple";

    /**
     * 远程翻译
     */
    String RPC = "rpc";

    /**
     * 枚举
     */
    String ENUM = "enum";
}
