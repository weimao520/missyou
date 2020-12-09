package com.lin.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author WeiMao
 * @create 2020-11-30 22:06
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {


    String message() default "字段不符合要求";

    int min() default 0;

    int max() default 8;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
