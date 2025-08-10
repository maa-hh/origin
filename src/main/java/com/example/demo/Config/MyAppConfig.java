package com.example.demo.Config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@EnableConfigurationProperties(MyAppProperties.class)
public class MyAppConfig {

    private final MyAppProperties properties;

    public MyAppConfig(MyAppProperties properties) {
        this.properties = properties;
    }

    @Bean
    public String myAppBean() {
        // 模拟初始化时用到配置
        System.out.println("Initializing MyAppBean with properties: " + properties);
        return "MyApp Bean for " + properties.getName() + " running at port " + properties.getPort();
    }
}
