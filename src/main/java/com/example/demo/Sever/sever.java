

package com.example.demo.Sever;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.data;
import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class sever {
    @Autowired
    data data;
    public List<User> select(int id){
        List<User>ans=data.selectid(id);
        return ans;
    }
    public Emp select1(int id){
        Emp ans=data.selectById(id);
        return ans;
    }
    public int deleteId (int id){
        return data.deleteById(id);
    }
    public Emp posts(Emp u){
        data.insert(u);
        return u;
    }
    public List<Emp>getAll() {
        return data.selectList(null);
    }

    /*public PageInfo<Emp> getAllLimit(int page, int size) {
        PageHelper.startPage(page,size);
        List<Emp> l=data.getAllLimit(page,size);
        return new PageInfo<>(l);
    }*/
    public IPage<Emp> getAllLimit(int page, int size) {
        // 创建分页对象，指定泛型为 Emp
        IPage<Emp> p = new Page<>(page, size);

        // 调用分页查询，返回分页结果
        IPage<Emp> pageResult = data.selectPage(p, null);

        return pageResult;
    }

    public List<Emp> selectListId(List<Emp> l) {
        return data.selectListId(l);
    }

    public boolean login(Emp e) {
        LambdaQueryWrapper<Emp> lq = new LambdaQueryWrapper<>();
        lq.eq(Emp::getId, e.getId())
                .eq(Emp::getUsername, e.getUsername())
                .eq(Emp::getPassword, e.getPassword());
        List<Emp> list = data.selectList(lq);
        Emp s=data.selectOne(lq);
       /* data.selectOne(lq);
        lq.groupBy(Emp::getId);
        lq.between(Emp::getId,10,20);
        lq.like(Emp::getUsername, "tom"); // 相当于 SQL: WHERE username LIKE '%tom%'
        lq.likeLeft(Emp::getUsername, "tom");  // WHERE username LIKE '%tom'
        lq.likeRight(Emp::getUsername, "tom"); // WHERE username LIKE 'tom%'
        List<Map<String,Object>> ans=data.selectMaps(lq);
        List<Integer> ids=new ArrayList<>();
        List<Emp> ansids=data.selectBatchIds(ids);
        data.deleteBatchIds(ids);*/
        return list != null && !list.isEmpty();  // 判断查询结果是否非空
    }
    public boolean optimsim(int id){
        Emp current = data.selectById(id);
        current.setName("小红");
        int s = data.updateById(current); // 自动带 version 判断，并自动 version+1
        return s > 0;
    }
}
