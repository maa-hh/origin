package com.example.demo.Config;

import com.example.demo.Aop.EnableMyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.example.demo.Config.MyBatis.class,com.example.demo.Config.WebMvcConfig.class})
//@EnableMyService({"com.example.demo.Sever.sever.class"})
/*
*@ConditionalOnProperty
@ConditionalOnBean
@ConditionalOnClass
* */

public class Config {
}
