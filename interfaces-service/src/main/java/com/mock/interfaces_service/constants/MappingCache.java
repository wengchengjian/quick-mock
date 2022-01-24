package com.mock.interfaces_service.constants;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.mock.api.entity.Project;
import com.mock.api.entity.SysUser;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 21:36
 * @Version 1.0.0
 */
public class MappingCache {
    /**
     * 代理对象类名->返回值
     */
    public static final Cache<String,String> RESPONSE_MAPPING = Caffeine.newBuilder().initialCapacity(100).maximumSize(10000).build();
}
