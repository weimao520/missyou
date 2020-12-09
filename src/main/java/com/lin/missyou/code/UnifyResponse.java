package com.lin.missyou.code;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WeiMao
 * @create 2020-04-18 18:34
 */
@AllArgsConstructor
@Data
public class UnifyResponse  {

    private int code;
    private String message;
    private String request;


//    public UnifyResponse(int code, String message, String request) {
//        this.code = code;
//        this.message = message;
//        this.request = request;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getRequest() {
//        return request;
//    }
//
//    public void setRequest(String request) {
//        this.request = request;
//    }
}
