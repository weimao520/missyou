package com.lin.missyou.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author WeiMao
 * @create 2020-04-26 20:40
 */
@Entity
@Data
public class BannerItem  extends BaseEntity{

    private static final long serialVersionUID = 8616490390242343098L;


    @Id
    private Long id;
    private String img;
    private String keyword;
    private Short type;

    private Long bannerId;
    private String name;


}
