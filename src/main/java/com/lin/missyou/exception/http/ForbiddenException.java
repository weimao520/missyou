package com.lin.missyou.exception.http;

/**
 * @author WeiMao
 * @create 2020-04-18 17:54
 */
public class ForbiddenException  extends HttpException{
    public ForbiddenException(int code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}
