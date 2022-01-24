package com.mock.group_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 翁丞健
 * @Date 2022/1/21 22:02
 * @Version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.mock.group_service.mapper")
public class GroupServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroupServiceApplication.class,args);
    }
}
