package com.example.demo.Dao;

import com.example.demo.Domain.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface data {
    @Select("select * from User where id=#{id}")
    public List<User> selectid(int id);
}
