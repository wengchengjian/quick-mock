package com.mock.api.exception;

import com.mock.api.constants.StatusCode;
import com.mock.api.result.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 19:16
 * @Version 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(value=RequestParamsNotFoundException.class)
    public BaseResponse handleParamsException(){
        log.warn("接口参数不能为空");
        return BaseResponse.Failure(StatusCode.PARAMS_NOT_FOUND);
    }
}
