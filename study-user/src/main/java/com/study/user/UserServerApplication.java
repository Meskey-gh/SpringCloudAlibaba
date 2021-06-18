package com.study.user;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 刘祖鸿
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.study.user.mapper")
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class UserServerApplication {

    public static void main(String[] args){
        SpringApplication.run(UserServerApplication.class,args);
    }
}
