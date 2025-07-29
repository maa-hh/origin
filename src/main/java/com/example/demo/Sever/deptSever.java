package com.example.demo.Sever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.deptMapper;
@Service
public class deptSever {
    @Autowired
    deptMapper deptMapper;
    public int deleteId(int id) {
        return deptMapper.deleteId(id);
    }
}
