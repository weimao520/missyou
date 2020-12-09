package com.lin.missyou.exception.http;

/**
 * @author WeiMao
 * @create 2020-12-05 22:09
 */
public class ParameterException extends HttpException {
    private static final long serialVersionUID = -2072200732343635159L;

    public ParameterException(int code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
