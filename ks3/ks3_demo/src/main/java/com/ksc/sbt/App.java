package com.ksc.sbt;


import com.ksyun.ks3.dto.Bucket;
import com.ksyun.ks3.dto.ResponseHeaderOverrides;
import com.ksyun.ks3.http.HttpClientConfig;
import com.ksyun.ks3.service.Ks3Client;
import com.ksyun.ks3.service.Ks3ClientConfig;
import com.ksyun.ks3.service.request.PutObjectRequest;

import java.io.File;
import java.util.List;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {


        Ks3ClientConfig config = new Ks3ClientConfig();
        /**
         * 设置服务地址
         * 杭州:kss.ksyun.com
         * 北京:ks3-cn-beijing.ksyun.com
         * 上海:ks3-cn-shanghai.ksyun.com
         * 香港:ks3-cn-hk-1.ksyun.com
         * 俄罗斯:ks3-rus.ksyun.com
         * 新加坡:ks3-sgp.ksyun.com
         * 广州：ks3-cn-guangzhou.ksyun.com
         */
        config.setEndpoint("ks3-cn-beijing.ksyun.com");//此处以北京为例
        /**
         *true：表示以自定义域名访问
         *false：表示以KS3的外网域名或内网域名访问，默认为false
         */
        config.setDomainMode(false);
        config.setProtocol(Ks3ClientConfig.PROTOCOL.http);
        /**
         *true表示以   endpoint/{bucket}/{key}的方式访问
         *false表示以  {bucket}.endpoint/{key}的方式访问
         *如果domainMode设置为true，pathStyleAccess可忽略设置
         */
        config.setPathStyleAccess(false);
        HttpClientConfig hconfig = new HttpClientConfig();
        //在HttpClientConfig中可以设置httpclient的相关属性，比如代理，超时，重试等。
        config.setHttpClientConfig(hconfig);

//         Ks3Client client = new Ks3Client("Your AK", "Your SK", config);

        List<Bucket> buckets = client.listBuckets();

        for (Bucket bucket : buckets) {
            System.out.println(bucket.getName());
            //获取bucket的拥有者（用户ID base64后的值）
        }

        PutObjectRequest request = new PutObjectRequest("ksc-sbt",

        "ks3_demo/pom.xml", new File("pom.xml"));
        client.putObject(request);

        request = new PutObjectRequest("ksc-sbt",
                "ks3_demo/pom.xml", new File("pom.xml"));
        client.putObject(request);


//生成一个1000秒后过期并重写返回的heade的外链

        ResponseHeaderOverrides overrides = new ResponseHeaderOverrides();

        overrides.setContentType("timage/png");

        String url = client.generatePresignedUrl("ksc-sbt","ks3_demo/image001.png",1000,overrides);

        System.out.println(url);
    }

}
