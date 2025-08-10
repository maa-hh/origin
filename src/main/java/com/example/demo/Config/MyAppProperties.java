package com.example.demo.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myapp")
public class MyAppProperties {

    private String name;
    private int port;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "MyAppProperties{name='" + name + "', port=" + port + '}';
    }
}
