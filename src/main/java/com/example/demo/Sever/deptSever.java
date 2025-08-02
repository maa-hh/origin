package com.example.demo.Sever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.deptMapper;
@Service
/*@ConditionalOnBean(name = "deptMapper")  // 如果 Spring 容器中有名为 deptMapper 的 Bean 才加载此类
@ConditionalOnClass(name = "com.mysql.cj.jdbc.Driver")//只有存在 MySQL 驱动类 com.mysql.cj.jdbc.Driver 时才加载这个 Bean
@ConditionalOnProperty(name = "custom.dept.enable", havingValue = "true", matchIfMissing = false) // 需要在配置文件中加上 custom.dept.enable=true*/
public class deptSever {    @Autowired

    deptMapper deptMapper;
    public int deleteId(int id) {
        return deptMapper.deleteId(id);
    }
}
