package com.lin.missyou.code.enumeration;

/**
 * d登录方式
 *
 * @author WeiMao
 * @create 2020-12-01 21:38
 */
public enum LoginType {

    USER_WX(0,"微信登录"),USER_EMAIL(1,"邮箱登录");

    Integer value;
    String description;
    LoginType(Integer value,String description) {
        this.value = value;
        this.description = description;
    }
}
