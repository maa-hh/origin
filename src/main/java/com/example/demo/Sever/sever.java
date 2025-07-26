package com.example.demo.Sever;

import com.example.demo.Dao.data;
import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sever {
    @Autowired
    data data;
    public List<Emp> select(int id){
        List<Emp>ans=data.selectid(id);
        return ans;
    }
    public void deleteId (int id){
        data.selectid(id);
    }
}
