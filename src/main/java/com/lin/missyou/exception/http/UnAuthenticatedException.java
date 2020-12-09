package com.lin.missyou.exception.http;

/**
 * 未登录
 * @author WeiMao
 * @create 2020-12-07 22:24
 */
public class UnAuthenticatedException  extends HttpException{
    private static final long serialVersionUID = 6766191140059678560L;

    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
