package com.lon.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lon
 * @since 2023-03-09
 */
@TableName("dic_dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {


    @TableId(value = "id")
    private Integer id;
    @TableField("pid")
    private Integer pid;
    @TableField("name")
    private String deptName;


}
