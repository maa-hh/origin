package com.example.demo;


import com.example.demo.DuraAndData.DuraAndData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")
//@ServletComponentScan
@EnableConfigurationProperties(DuraAndData.class)//此注解可将使用@ConfigurationProperties的加入容器 相当于component
public class DemoApplication {
    public static void main(String[] args) {
       //// ApplicationContext cx= new ClassPathXmlApplicationContext("");

        SpringApplication.run(DemoApplication.class, args);
    }
}

