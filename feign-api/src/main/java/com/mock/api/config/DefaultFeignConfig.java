package com.mock.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author 翁丞健
 * @Date 2022/1/23 20:14
 * @Version 1.0.0
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

}
