package com.example.demo.Aop;

import java.lang.annotation.*;

// 定义注解的作用范围，默认是类和接口
@Target({ElementType.METHOD, ElementType.TYPE})

// 运行时可通过反射读取
@Retention(RetentionPolicy.RUNTIME)

// 是否包含在javadoc中
@Documented

public @interface MyAnnotation {

}