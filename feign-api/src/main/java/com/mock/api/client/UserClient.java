package com.mock.api.client;

import com.mock.api.entity.Project;
import com.mock.api.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 翁丞健
 * @Date 2022/1/21 18:44
 * @Version 1.0.0
 */
@FeignClient(value = "userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    SysUser findById(@PathVariable("id") Long userId);
}
