package com.example.demo;


import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.example.demo.DuraAndData.DuraAndData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")
//@ServletComponentScan
@EnableConfigurationProperties(DuraAndData.class)//此注解可将使用@ConfigurationProperties的加入容器 相当于component
@EnableCaching //启用缓存
@EnableScheduling
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.example")
public class DemoApplication {
    public static void main(String[] args) {
       //// ApplicationContext cx= new ClassPathXmlApplicationContext("");
        /*args[0]="--server.port=80";
        args[0]="--server.config.name=ebank";
        args[0]="--server.config.loaction=classpath:/ , ..";*/
        //关闭热部署System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(DemoApplication.class, args);
    }
}

