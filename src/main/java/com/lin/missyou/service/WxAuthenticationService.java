package com.lin.missyou.service;

/**
 * @author WeiMao
 * @create 2020-12-03 21:37
 */
public interface WxAuthenticationService {

    String code2Session(String code);
}
