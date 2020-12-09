package com.lin.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-29 15:15
 */
@Convert
public class ListAndJson implements AttributeConverter<List<Object>,String> {

    @Autowired
    ObjectMapper objectMapper;
    @Override
    public String convertToDatabaseColumn(List<Object> strings) {
        try {
            return objectMapper.writeValueAsString(strings);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        try {
            if(s==null){
                return null;
            }
            return this.objectMapper.readValue(s,List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }

    }

}
