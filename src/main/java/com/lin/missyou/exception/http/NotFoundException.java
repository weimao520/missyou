package com.lin.missyou.exception.http;

/**
 * @author WeiMao
 * @create 2020-04-18 17:43
 */
public class NotFoundException extends HttpException {

    public NotFoundException(int code) {

        this.httpStatusCode = 404;
        this.code = code;
    }
}
