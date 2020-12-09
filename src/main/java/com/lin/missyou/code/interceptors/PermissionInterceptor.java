package com.lin.missyou.code.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.exception.http.UnAuthenticatedException;
import com.lin.missyou.util.JwtToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

/**
 * @author WeiMao
 * @create 2020-12-07 21:44
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if (!scopeLevel.isPresent()) {
            return true;
        }
        // 获取前端传来的token 格式： Bearer   token字符串
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isEmpty(bearerToken)) {
            throw new UnAuthenticatedException(10004);
        }
//        标准，一般token前面会加上这个也可以不加
        if (!bearerToken.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }
        String [] token = bearerToken.split(" ");
        if (token.length != 2) {
            throw new UnAuthenticatedException(10004);
        }
        Optional<Map<String, Claim>> stringClaimMap = JwtToken.getClaims(token[1]);
        Map<String, Claim> map = stringClaimMap.orElseThrow(() -> {
            throw new UnAuthenticatedException(1004);
        });
        return this.hasPermission(scopeLevel.get(), map);
    }


    /**
     * 判断它是否有权限 scopeLevel 权限等级
     * @param scopeLevel
     * @param map
     * @return
     */
    private boolean hasPermission(ScopeLevel scopeLevel,Map<String,Claim> map) {
        int level = scopeLevel.value();
        Integer scope = map.get("scope").asInt();
//        用户的等级小于方法注解上的设置的等级
        if (level > scope) {
            throw new ForbiddenException(10005);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }


    private Optional<ScopeLevel> getScopeLevel(Object o) {
        // 判断是否是HandlerMethod 类型
        if (o instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) o;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            if (scopeLevel == null) {
                return Optional.empty();
            }
            return Optional.of(scopeLevel);
        }
        return Optional.empty();
    }
}
