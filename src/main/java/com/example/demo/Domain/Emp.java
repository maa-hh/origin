package com.example.demo.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private  Integer id;
    private  String username;
    private  String password;
    private  String name;
    private  String gender;
    private  String image;
    private  String job;
    private LocalDate entrydate;
    private Integer deptid;
    private LocalDateTime createTime;
    private  LocalDateTime updateTime;
}
