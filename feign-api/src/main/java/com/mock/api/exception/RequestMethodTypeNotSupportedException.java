package com.mock.api.exception;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 21:43
 * @Version 1.0.0
 */
public class RequestMethodTypeNotSupportedException extends RuntimeException{
    public RequestMethodTypeNotSupportedException() {
        super();
    }

    public RequestMethodTypeNotSupportedException(String message) {
        super(message);
    }

    public RequestMethodTypeNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestMethodTypeNotSupportedException(Throwable cause) {
        super(cause);
    }

    protected RequestMethodTypeNotSupportedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
