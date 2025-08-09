package com.example.demo.admin;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
//info 是用来展示应用信息的，比如版本、作者、环境等。
@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("custom", "自定义信息")
                .withDetail("time", System.currentTimeMillis());
    }
}
