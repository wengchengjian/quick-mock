package com.mock.interfaces_service.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 翁丞健
 * @Date 2022/1/23 21:34
 * @Version 1.0.0
 */
@RestController
public class InterfaceMappingController {

    public String resolve() {
        return "12331";
    }

}
