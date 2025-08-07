package com.example.demo.Shedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {

    // 每5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() {
        System.out.println("任务1执行时间：" + System.currentTimeMillis());
    }

    // 每10秒执行一次（固定速率）
    @Scheduled(fixedRate = 10000)
    public void task2() {
        System.out.println("任务2执行时间：" + System.currentTimeMillis());
    }

    // 上一个任务执行完成后等待5秒再执行
    @Scheduled(fixedDelay = 5000)
    public void task3() {
        System.out.println("任务3执行时间：" + System.currentTimeMillis());
    }
}

