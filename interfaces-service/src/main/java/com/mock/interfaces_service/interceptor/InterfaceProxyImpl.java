package com.mock.interfaces_service.interceptor;

import com.alibaba.fastjson.JSON;
import com.mock.interfaces_service.constants.MappingCache;
import net.minidev.json.JSONArray;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author 翁丞健
 * @Date 2022/1/23 21:32
 * @Version 1.0.0
 */
public class InterfaceProxyImpl implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("resolve")){
            // 当handler被调用时，执行此逻辑返回路由对应返回值
            return MappingCache.RESPONSE_MAPPING.get(o.getClass().getName(), key->"");
        }
        return methodProxy.invokeSuper(o,objects);
    }
}
