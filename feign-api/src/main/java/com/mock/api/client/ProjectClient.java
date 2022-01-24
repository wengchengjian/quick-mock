package com.mock.api.client;

import com.mock.api.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 20:45
 * @Version 1.0.0
 */
@FeignClient("projectservice")
public interface ProjectClient {

    @GetMapping("/project/{id}")
    Project findById(@PathVariable("id") Long projectId);
}
