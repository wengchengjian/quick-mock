package com.mock.api.exception;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 19:17
 * @Version 1.0.0
 */
public class RequestParamsNotFoundException extends RuntimeException{
    public RequestParamsNotFoundException() {
        super();
    }

    public RequestParamsNotFoundException(String message) {
        super(message);
    }

    public RequestParamsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestParamsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RequestParamsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
