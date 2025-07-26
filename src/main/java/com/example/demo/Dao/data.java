package com.example.demo.Dao;

import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface data {
   // @Select("select * from User where id=#{id}")
    public List<Emp> selectid(int id);

    @Delete("delete * from Emp where id=#{id}")
    public void delete(int id);

    @Select("select * from Emp where username like contact(%,#{name},%)")
    public List<Emp> selectname(@Param("name") String name);

    public List<Emp> selectByIds(List<Integer> ids);

    public  List<Emp> select11(int id);
}
