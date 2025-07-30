package com.example.demo.Utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
@Data
public class ConstantPropertiesUtils {
    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
}
