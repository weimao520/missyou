package com.lin.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 *  转换 {id:1,name:"xxx"} 格式的json
 * AttributeConverter  第一个是java 中的类型  第二个是数据库中的类型（json）
 * @author WeiMao
 * @create 2020-04-29 11:42
 */
public class MapAndJson implements AttributeConverter<Map<String,Object>,String> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return objectMapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9000);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9000);
        }
    }

}
