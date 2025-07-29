package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface deptMapper {
    @Delete("delete from Dept where id=#{id}")
    public int deleteId(int id);
}
