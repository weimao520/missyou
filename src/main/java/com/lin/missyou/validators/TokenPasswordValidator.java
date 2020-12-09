package com.lin.missyou.validators;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author WeiMao
 * @create 2020-11-30 22:10
 */
public class TokenPasswordValidator implements ConstraintValidator<TokenPassword,String > {

    private Integer min;
    private Integer max;

    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    /**
     * value 就是要注解的文本
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        return value.length() >= this.min && value.length() <= this.max;
    }
}
