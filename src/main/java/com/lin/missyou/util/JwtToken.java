package com.lin.missyou.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author WeiMao
 * @create 2020-12-06 19:02
 */
@Component
public class JwtToken {


    private static String jwtKey;

    private static  Integer tokenExpiredIn;

    private static Integer defaultScope = 8;

    @Value("${missyou.security.jwt-key}")
    public void setJwtKey(String jwtKey) {
        JwtToken.jwtKey = jwtKey;
    }

    @Value("${missyou.security.token-expired-in}")
    public void setTokenExpiredIn(Integer tokenExpiredIn) {
        JwtToken.tokenExpiredIn = tokenExpiredIn;
    }

    /**
     * uid 用户id
     * scope 权限等级
     * @param uid
     * @param scope
     * @return
     */
    public static String makeToken(Long uid, Integer scope) {
        return getToken(uid, scope);
    }

    public static String makeToken(Long uid) {
        return getToken(uid, JwtToken.defaultScope);
    }

    public static Optional<Map<String, Claim>> getClaims(String token) {
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        DecodedJWT verify ;
        try {
            verify = JWT.require(algorithm).build().verify(token);
        } catch (JWTVerificationException e) {
            return Optional.empty() ;
        }
        return Optional.of(verify.getClaims());
    }

    /**
     * 判断token是否合法
     * @param token
     * @return
     */
    public static Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }


    public static String getToken(Long id, Integer scope) {
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        Map<String, Date> map = JwtToken.calculateExpiredIssues();
        return JWT.create().
                withClaim("uid", id).
                withClaim("scope", scope).
                withExpiresAt(map.get("expiredTime")). // 过期时间
                withIssuedAt(map.get("now")). // 签发时间
                sign(algorithm);

    }

    private static Map<String, Date> calculateExpiredIssues() {
        Map<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, JwtToken.tokenExpiredIn);
        map.put("now", now);
        map.put("expiredTime", calendar.getTime());
        return map;
    }
}
