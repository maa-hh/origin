package com.example.demo.Shedul;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyTask extends QuartzJobBean {

    // 你可以在这里注入 Spring Bean（需要使用 @Autowired 或 setter 注入）
    // @Autowired
    // private MyService myService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // 获取传入的 JobDataMap 数据
        System.out.println("Sheduling");
        // 执行任务逻辑
        // myService.doSomething();
    }
}

