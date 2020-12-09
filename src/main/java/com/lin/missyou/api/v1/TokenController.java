package com.lin.missyou.api.v1;

import com.lin.missyou.dto.TokenDTO;
import com.lin.missyou.dto.TokenGetDto;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.service.WxAuthenticationService;
import com.lin.missyou.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WeiMao
 * @create 2020-11-30 21:31
 */
@RestController
@RequestMapping
public class TokenController {


    @Autowired
    private WxAuthenticationService wxAuthenticationService;


    @PostMapping("getToken")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDto tokenGetDto) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (tokenGetDto.getLoginType()) {
            case USER_WX:
                token = this.wxAuthenticationService.code2Session(tokenGetDto.getAccount());
                break;
            case USER_EMAIL:
                break;
            default:
                throw new NotFoundException(10003);
        }
        map.put("token", token);
        return map;
    }

    @PostMapping("verify")
    public Map<String, Boolean> verify(@RequestBody TokenDTO tokenDTO) {
        Map<String, Boolean> map = new HashMap<>();
        Boolean valid = JwtToken.verifyToken(tokenDTO.getToken());
        map.put("is_valid", valid);
        return map;
    }
}
