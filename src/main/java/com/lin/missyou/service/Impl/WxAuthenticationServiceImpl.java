package com.lin.missyou.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.model.User;
import com.lin.missyou.repository.UserRepository;
import com.lin.missyou.service.WxAuthenticationService;
import com.lin.missyou.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author WeiMao
 * @create 2020-12-03 21:37
 */
@Service
public class WxAuthenticationServiceImpl implements WxAuthenticationService {


    @Value("${wx.code2session}")
    private String code2SessionUrl;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String appsecret;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String code2Session(String code) {

        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.appsecret, code);

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject(url, String.class);
        Map<String, Object> map = new HashMap<>();
        try {
            map= objectMapper.readValue(forObject, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(map);
    }


    private String registerUser(Map<String, Object> map) {
       String openid=(String) map.get("openid");
        if (StringUtils.isEmpty(openid)) {
            throw new ParameterException(20004);
        }
        Optional<User> byOpenid = this.userRepository.findByOpenid(openid);
//        存在
        if (byOpenid.isPresent()) {
            // 返回JWT令牌
            return JwtToken.makeToken(byOpenid.get().getId());
        }
        User build = User.builder().openid(openid).build();
        this.userRepository.save(build);
//        返回jwt令牌
        return JwtToken.makeToken(build.getId());
    }
}
