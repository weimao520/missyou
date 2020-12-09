package com.lin.missyou.exception.http;

/**
 * @author WeiMao
 * @create 2020-04-29 13:15
 */
public class ServerErrorException extends HttpException {


    public ServerErrorException(int code) {
        this.code = code;
        this.httpStatusCode = 500;
    }
}
