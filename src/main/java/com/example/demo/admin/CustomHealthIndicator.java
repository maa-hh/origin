package com.example.demo.admin;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
//health 用于显示应用的健康状态，比如数据库连接、缓存、磁盘空间等。
@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // 这里可以做真实检测，比如 ping 某个服务
        boolean serverOK = true;

        if (serverOK) {
            return Health.up()
                    .withDetail("custom-service", "运行正常")
                    .withDetail("timestamp", System.currentTimeMillis())
                    .build();
        } else {
            return Health.down()
                    .withDetail("custom-service", "连接失败")
                    .build();
        }
    }
}

