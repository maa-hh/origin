package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication

public class DemoApplication {

    public static void main(String[] args) {

       //// ApplicationContext cx= new ClassPathXmlApplicationContext("");
        SpringApplication.run(DemoApplication.class, args);
    }

}
