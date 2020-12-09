package com.lin.missyou.code.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 处理所有带有 requestMapping 注解的 类
 * @author WeiMao
 * @create 2020-04-22 14:30
 */
public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {


    @Value("${missyou.api-package}")
    private String apiPackagePath;
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {

        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if (mappingInfo != null) {
            String prefix = this.getPrefix(handlerType);
            //  路劲名 合并
            return RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
        }
        return mappingInfo;
    }



    private String getPrefix(Class<?> handlerType){
        String packageName = handlerType.getPackage().getName();
        String dotPath = packageName.replaceAll(this.apiPackagePath, "");
        return dotPath.replace(".","/");
    }
}
