package com.example.demo.Domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("Emp")
public class Emp {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private  String username;
    //@TableField(value = "password",select = false)
    private  String password;
    private  String name;
    private  short gender;
    private  String image;
    private  String job;
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDateTime createTime;
    private  LocalDateTime updateTime;
    @TableField(exist = false)
    private Integer online;
    @TableLogic
    private Integer isDeleted;
    @Version
    private  Integer version;
}