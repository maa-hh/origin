package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ServletComponentScan
public class DemoApplication {
    public static void main(String[] args) {
       //// ApplicationContext cx= new ClassPathXmlApplicationContext("");
        SpringApplication.run(DemoApplication.class, args);
    }
}

