package com.lin.missyou.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @author WeiMao
 * @create 2020-04-27 20:15
 */
@Builder
@Data
public class PageCounter {
    private Integer page;
    private Integer count;
}
