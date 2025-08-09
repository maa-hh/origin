package com.example.demo.admin;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "myendpoint") // 访问路径 /actuator/myendpoint
public class MyCustomEndpoint {

    // 存储配置信息（模拟数据库）
    private final Map<String, String> configData = new ConcurrentHashMap<>();

    public MyCustomEndpoint() {
        configData.put("version", "1.0");
        configData.put("mode", "debug");
    }
    @ReadOperation // GET 请求
    public Map<String, Object> systemInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("app", "My Custom Actuator Endpoint");
        map.put("uptime.seconds", ManagementFactory.getRuntimeMXBean().getUptime() / 1000);
        map.put("java.version", System.getProperty("java.version"));
        return map;
    }
    // POST/PUT 请求 - 更新配置
    @WriteOperation
    public String updateConfig(@Selector String key, String value) {
        configData.put(key, value);
        return "Updated key=" + key + " to value=" + value;
    }

    // DELETE 请求 - 删除某个配置
    @DeleteOperation
    public String deleteConfig(@Selector String key) {
        if (configData.remove(key) != null) {
            return "Deleted key=" + key;
        }
        return "Key not found: " + key;
    }
}

