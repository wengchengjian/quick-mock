package com.mock.interfaces_service;

import com.mock.api.client.GroupClient;
import com.mock.api.client.ProjectClient;
import com.mock.api.client.UserClient;
import com.mock.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 翁丞健
 * @Date 2022/1/21 22:02
 * @Version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.mock.interfaces_service.mapper")
@EnableFeignClients(clients = {UserClient.class, ProjectClient.class, GroupClient.class},defaultConfiguration = DefaultFeignConfig.class)
public class InterfacesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterfacesServiceApplication.class,args);
    }
}
