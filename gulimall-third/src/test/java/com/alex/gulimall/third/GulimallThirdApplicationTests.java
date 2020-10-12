package com.alex.gulimall.third;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

@SpringBootTest
public class GulimallThirdApplicationTests {

    @Autowired
    private OSSClient ossClient;

    @Test
    public void upload() {
        String bucketName = "gulimall-alex-dev";
// <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "C:\\Users\\Administrator\\Pictures\\Saved Pictures\\11.jpg";
        String content = "Hello OSS";
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
        System.out.println("上传完成！！");
    }
}
