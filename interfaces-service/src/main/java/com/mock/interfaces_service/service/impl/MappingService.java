package com.mock.interfaces_service.service.impl;

import com.mock.api.entity.InterfacesVO;
import com.mock.api.exception.RequestMethodTypeNotSupportedException;
import com.mock.interfaces_service.constants.MappingCache;
import com.mock.interfaces_service.interceptor.InterfaceProxyImpl;
import com.mock.interfaces_service.controller.InterfaceMappingController;
import com.mock.interfaces_service.service.InterfacesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;


/**
 * @Author 翁丞健
 * @Date 2022/1/22 19:22
 * @Version 1.0.0
 */
@Service
@Slf4j
public class MappingService {


    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private InterfacesService interfacesService;

    RequestMappingInfo requestMappingInfo;

    public void addMapping(InterfacesVO requestInfo) {
        // 这里的path和请求方式都和我们在jar包中那个类定义的是一样的，不然照样会出现404,还有其他参数，这里就先不设置了

        // 1.获取基本信息
        String rootUrl = requestInfo.getProject().getBaseUrl();

        String groupUrl = requestInfo.getGroup().getBaseUrl();

        String address = requestInfo.getAddress();

        String path = rootUrl + groupUrl + address;

        String methodName = getHandlerMethodName(requestInfo);

        // 2.获取代理对象 基于cglib
        InterfaceMappingController proxy = createProxy();

        // 2. 创建mappingInfo对象
        requestMappingInfo = RequestMappingInfo
                .paths(path)
                .methods(getRequestType(requestInfo.getMethodType()))
                .build();



        Method targetMethod = ReflectionUtils.findMethod(InterfaceMappingController.class, "resolve"); // 找到处理该路由的方法


        PatternsRequestCondition patternsRequestCondition = new PatternsRequestCondition(path);
        RequestMethodsRequestCondition requestMethodsRequestCondition = new RequestMethodsRequestCondition(getRequestType(requestInfo.getMethodType()));
//
        RequestMappingInfo mapping_info = new RequestMappingInfo(patternsRequestCondition, requestMethodsRequestCondition, null, null, null, null, null);

        requestMappingHandlerMapping.registerMapping(mapping_info, proxy, targetMethod); // 注册映射处理



        MappingCache.RESPONSE_MAPPING.put(proxy.getClass().getName(),requestInfo.getResponseText()); // 注册返回值缓存

        // 这里就注册了我们的handlermapping，但是这里只能一个一个方法进行注册（而且不限制你重复注册，但是如果重复注册的话，请求的时候会报错）
    }



    private InterfaceMappingController createProxy(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(InterfaceMappingController.class);

        enhancer.setCallback(new InterfaceProxyImpl());



        return (InterfaceMappingController) enhancer.create();
    }

    private String getHandlerMethodName(InterfacesVO requestInfo) {
        return new StringBuffer(requestInfo.getProject().getId().toString())
                .append(requestInfo.getGroup().getBaseUrl())
                .append(requestInfo.getAddress()).toString();
    }

    public void removeMapping() {
        requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
    }

    public RequestMethod getRequestType(String type){

        // 大写转换
        type = type.toUpperCase();

        switch(type){
            case "GET":
                return RequestMethod.GET;
            case "POST":
                return RequestMethod.POST;
            case "PUT":
                return RequestMethod.PUT;
            case "DELETE":
                return RequestMethod.DELETE;
            case "PATCH":
                return RequestMethod.PATCH;
            case "TRACE":
                return RequestMethod.TRACE;
            case "HEAD":
                return RequestMethod.TRACE;
            default:
                throw new RequestMethodTypeNotSupportedException();
        }
    }
}
