package com.mock.interfaces_service.controller;


import com.mock.api.request.Interface.CreateInterfaceRequest;
import com.mock.api.result.BaseResponse;
import com.mock.interfaces_service.service.InterfacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/interfaces")
public class InterfacesController {

    @Autowired
    private InterfacesService interfacesService;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @PostMapping("/create")
    public BaseResponse create(@Validated @RequestBody  CreateInterfaceRequest request){
        interfacesService.create(request);

        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        return BaseResponse.Success();
    }

}

