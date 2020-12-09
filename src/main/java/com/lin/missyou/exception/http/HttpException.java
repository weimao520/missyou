package com.lin.missyou.exception.http;

/**
 * @author WeiMao
 * @create 2020-04-18 17:34
 */
public class HttpException extends RuntimeException {

    private static final long serialVersionUID = 7961528685755424096L;
    protected Integer code;
    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {

        return httpStatusCode;
    }
}
