package com.study.minio;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 刘祖鸿
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableDiscoveryClient
@MapperScan("com.study.minio.mapper")
@EnableSwagger2
@EnableSwaggerBootstrapUI
@EnableFeignClients
public class MinioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioApplication.class,args);
    }

}
