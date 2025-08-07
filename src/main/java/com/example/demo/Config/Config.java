package com.example.demo.Config;

import com.example.demo.Aop.EnableMyService;
import com.example.demo.DuraAndData.DuraAndData;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.example.demo.Config.MyBatis.class,com.example.demo.Config.WebMvcConfig.class,com.example.demo.Config.QuartzConfig.class})
//@EnableMyService({"com.example.demo.Sever.sever.class"})
/*
*@ConditionalOnProperty
@ConditionalOnBean
@ConditionalOnClass
* */

public class Config {
}
