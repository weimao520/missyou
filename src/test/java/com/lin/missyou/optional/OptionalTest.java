package com.lin.missyou.optional;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author WeiMao
 * @create 2020-04-30 20:06
 */
public class OptionalTest {


    public void as(){
        System.out.println(".......");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void ss(){
       int s= 1 / 0;
       as();
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)

    public void testOptional() {
        ss();
        System.out.println(".......");

    }


}
