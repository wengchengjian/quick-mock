package com.mock.api.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author 翁丞健
 * @Date 2022/1/21 18:44
 * @Version 1.0.0
 */
@FeignClient(value = "userservice")
public class UserClient {

}
