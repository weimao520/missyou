package com.lin.missyou.vo;

import lombok.Data;

/**
 * @author WeiMao
 * @create 2020-04-30 17:50
 */
@Data
public class ThemePureVO {

    private  Long id;
    private String title;
    private String description;
    private String name;
    private String tplName;

    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;
}
