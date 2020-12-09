package com.lin.missyou.util;

import com.lin.missyou.bo.PageCounter;

/**
 * @author WeiMao
 * @create 2020-04-27 20:05
 */
public class CommonUtil {
    public static PageCounter convertToPageParameter(Integer start, Integer count){
        int pageNum = start / count;
        PageCounter build = PageCounter.builder().page(pageNum).count(count).build();
        return build;
    }
}
