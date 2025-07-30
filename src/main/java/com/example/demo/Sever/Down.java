package com.example.demo.Sever;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.example.demo.Utils.ConstantPropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Down {

    @Autowired
    ConstantPropertiesUtils ali;

    // 通过spring调用此方法来下载文件
    public String downloadFile(String objectName) throws Exception {
        String endpoint = ali.getEndpoint();
        String accessKeyId = ali.getKeyId();
        String accessKeySecret = ali.getKeySecret();
        String bucketName = ali.getBucketName();
        String localFile = "D:\\"+objectName;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 下载文件到本地
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(localFile));

        ossClient.shutdown();
        return ("文件下载完成");
    }
}
