package com.lin.missyou.service;

import com.lin.missyou.dto.TokenGetDto;

/**
 * @author WeiMao
 * @create 2020-12-03 21:27
 */
public interface AuthenticationService {

     void getTokenByEmail(TokenGetDto tokenGetDto);

    String validateByWx(TokenGetDto tokenGetDto);

    void register();
}
