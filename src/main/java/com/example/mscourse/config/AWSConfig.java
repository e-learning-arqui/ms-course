package com.example.mscourse.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ivs.AmazonIVS;
import com.amazonaws.services.ivs.AmazonIVSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Bean
    public AmazonIVS amazonIVS() {
        return AmazonIVSClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKeyId, secretKey)))
                .withRegion(region)
                .build();
    }
}
