package com.lin.missyou.validators;

import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author WeiMao
 * @create 2020-04-23 14:42
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PasswordEqual {

    String message() default "passwords are not equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
