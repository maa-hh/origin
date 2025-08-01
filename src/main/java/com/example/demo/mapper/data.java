package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface data extends BaseMapper<Emp> {
    @Select("select * from User where id=#{id}")
   public List<User> selectid(int id);

   // @Select("select * from Emp where id=#{id}")

    List<Emp> selectListId(@Param("l") List<Emp> l);
}
