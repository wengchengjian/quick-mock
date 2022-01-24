package com.mock.api.result;

import com.mock.api.constants.StatusCode;
import lombok.*;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 18:54
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
public class BaseResponse<T> {

    private String msg;

    private T data;

    private Integer code;

    private static final StatusCode SUCCESS_CODE = StatusCode.SUCCESS ;

    public BaseResponse(String msg,Integer code){
        this(msg,null,code);
    }

    public BaseResponse(){
        this(SUCCESS_CODE.getMsg(),null,SUCCESS_CODE.getCode());
    }

    public BaseResponse(T data){
        this(SUCCESS_CODE.getMsg(),data,SUCCESS_CODE.getCode());
    }

    public static <T> BaseResponse<T> Success(T data){
        return new BaseResponse(data);
    }

    public static <T> BaseResponse<T> Success(){
        return new BaseResponse();
    }

    public static <T> BaseResponse<T> Failure(StatusCode status){
        return new BaseResponse(status.getMsg(),status.getCode());
    }


}
