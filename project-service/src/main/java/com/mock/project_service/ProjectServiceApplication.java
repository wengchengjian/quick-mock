package com.mock.project_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 翁丞健
 * @Date 2022/1/21 22:02
 * @Version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.mock.project_service.mapper")
public class ProjectServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectServiceApplication.class,args);
    }
}
