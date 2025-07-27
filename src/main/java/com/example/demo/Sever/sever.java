package com.example.demo.Sever;

import com.example.demo.mapper.data;
import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sever {
    @Autowired
    data data;
    public List<User> select(int id){
        List<User>ans=data.selectid(id);
        return ans;
    }
    public List<Emp> select1(int id){
        List<Emp>ans=data.select(id);
        return ans;
    }
    public int deleteId (int id){
        return data.deleteId(id);
    }
    public Emp posts(Emp u){
        data.posts(u);
        return u;
    }
    public List<Emp> getAll() {
        return data.getAll();
    }
}
