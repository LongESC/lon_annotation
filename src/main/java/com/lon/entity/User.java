package com.lon.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.lon.annotation.TranField;
import com.lon.annotation.TransType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @projectName: lon_v3
 * @package: com.lon.lon_v3.entity
 * @className: User
 * @author: LONZT
 * @description: TODO
 * @date: 2023/5/9 14:41
 * @version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "md_user")
public class User implements Serializable{

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "uno")
    private String uno;
    @TableField(value = "role")
    private Integer role;

    @TranField(type = TransType.DICTIONARY)
    @TableField(value = "gender")
    private Integer gender;

    @TableField(value = "name")
    private String name;

    @TableField(value = "dept")
    @TranField(type = TransType.SIMPLE, tableName = "dic_dept",tableField = "name",tableMapField = "id")
    private String dept;

    @TableField(value = "home")
    private String home;

    @TableField(value = "clsName")
    private String clsName;

    @TableField(value = "tchName")
    private String tchName;

    @TableField(exist = false)
    private Rank rank;


}
