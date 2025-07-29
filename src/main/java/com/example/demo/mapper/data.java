package com.example.demo.mapper;

import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface data {
    @Select("select * from User where id=#{id}")
   public List<User> selectid(int id);

   // @Select("select * from Emp where id=#{id}")
    public List<Emp> select(int id);

    @Delete("DELETE FROM Emp WHERE id = #{id}")
    public int deleteId(int id);

    @Select("select * from Emp where username like contact(%,#{name},%)")
    public List<Emp> selectname(@Param("name") String name);

    public List<Emp> selectByIds(List<Integer> ids);

    public  List<Emp> select11(int id);
    public void deleteid(int id);

   @Insert("INSERT INTO emp (name, age, dept) VALUES (#{name}, #{age}, #{dept})")
   @Options(useGeneratedKeys = true, keyProperty = "id")//主键自增 赋值id
   public int insertEmp(Emp emp);
    @Select("select * from Emp")
    List<Emp> getAll();
    @Insert("insert into Emp values (#{id},#{username},#{password},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void posts(Emp u);
    @Select("select  * from Emp limit #{page},#{size}")
    List<Emp> getAllLimit(@Param("page") int page, @Param("size") int size);

    List<Emp> selectListId(@Param("l") List<Emp> l);
}
