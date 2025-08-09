package com.example.demo.admin;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
//metrics 用于显示各种数值型指标，比如 CPU 使用率、请求数等
@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        // 自定义 gauge 指标
        meterRegistry.gauge("custom_gauge_metric", 42);

        // 自定义 counter 指标
        meterRegistry.counter("custom_counter_metric").increment(1.0);
    }
}

