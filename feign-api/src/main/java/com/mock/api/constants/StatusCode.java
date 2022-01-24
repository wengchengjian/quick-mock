package com.mock.api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 19:03
 * @Version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum StatusCode{
    /**
     * 成功请求接口
     */
    SUCCESS(0,"请求接口成功!"),
    PARAMS_NOT_FOUND(204,"接口参数不能为空"),
    ;
    private Integer code;
    private String msg;

}
