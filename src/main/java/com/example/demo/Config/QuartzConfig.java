package com.example.demo.Config;

import com.example.demo.Shedul.MyTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

public class QuartzConfig {

    @Bean
    public JobDetail myTaskDetail() {
        return JobBuilder.newJob(MyTask.class)
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger myTaskTrigger(JobDetail myTaskDetail) { // ✅ 参数注入
        return TriggerBuilder.newTrigger()
                .forJob(myTaskDetail) // 使用注入的 Bean
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
    }

}

