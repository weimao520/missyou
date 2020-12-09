package com.lin.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author WeiMao
 * @create 2020-04-29 17:28
 */
@Component
public class GenericAndJson {

    private  static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        GenericAndJson.objectMapper = objectMapper;
    }

    public static <T> String  objectToJson(T o){
        try {
            return GenericAndJson.objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String s,TypeReference<T> tr) {
        if(null == s){
            return null;
        }
        try{
            T o = GenericAndJson.objectMapper.readValue(s,tr);
            return o;
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
    public static <T> T jsonToObject(String s) {
        if(null == s){
            return null;
        }
        try{
            T o = GenericAndJson.objectMapper.readValue(s, new TypeReference<T>() {});
            return o;
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
