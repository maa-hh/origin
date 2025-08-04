package com.example.demo.Sever;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;
import com.example.demo.mapper.data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Slf4j
public class deptServerImplem extends ServiceImpl<data, Emp> implements deptSever{
    @Autowired
    private data data;

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean save(Emp entity) {
        return super.save(entity);
    }

    @Override
    public Emp getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean updateById(Emp entity) {
        return super.updateById(entity);
    }
}
