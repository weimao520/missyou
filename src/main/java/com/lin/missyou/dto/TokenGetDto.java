package com.lin.missyou.dto;

import com.lin.missyou.code.enumeration.LoginType;
import com.lin.missyou.validators.TokenPassword;
import lombok.Data;

import javax.validation.constraints.NotBlank;
/**
 * @author WeiMao
 * @create 2020-11-30 21:48
 */
@Data
public class TokenGetDto {

    @NotBlank(message = "不允许为空")
    private String account;


    @TokenPassword(max = 6,message = "{token.password}")
    private String password;

    private LoginType loginType;
}
