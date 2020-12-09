package com.lin.missyou.service.Impl;

import com.lin.missyou.dto.TokenGetDto;
import com.lin.missyou.service.AuthenticationService;
import org.springframework.stereotype.Service;

/**
 * @author WeiMao
 * @create 2020-12-03 21:28
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public void getTokenByEmail(TokenGetDto tokenGetDto) {

    }

    @Override
    public String validateByWx(TokenGetDto tokenGetDto) {
        return null;
    }

    @Override
    public void register() {

    }
}
