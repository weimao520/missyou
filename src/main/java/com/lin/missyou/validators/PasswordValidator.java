package com.lin.missyou.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * 注解关联类  必须实现这个接口
 * 第二个：自定义注解修饰的目标的类型
 * @author WeiMao
 * @create 2020-04-23 17:06
 */
public class PasswordValidator  implements ConstraintValidator<PasswordEqual,Object> {


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        return false;
    }
}
