package com.lin.missyou.code.configuration;

import com.lin.missyou.code.hack.AutoPrefixUrlMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author WeiMao
 * @create 2020-04-22 16:38
 */
@Component
public class AutoPrefixConfiguration implements WebMvcRegistrations {


    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new AutoPrefixUrlMapping();
    }
}
