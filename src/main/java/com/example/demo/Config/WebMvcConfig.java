package com.example.demo.Config;

import com.example.demo.Aop.EnableMyService;
import com.example.demo.Filter.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

/*@EnableMyService({
        "com.example.demo.Sever",
        "com.example.demo.Config.MyBatis"
})*/
//import selector 初始化bean

public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")        // 拦截所有请求
                .excludePathPatterns("/login"); // 排除登录接口
    }
}
