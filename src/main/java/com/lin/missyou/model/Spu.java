package com.lin.missyou.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-27 12:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Where(clause = "delete_time is null and online=1")
public class Spu extends BaseEntity {
    private static final long serialVersionUID = 7215134950099585069L;

    @Id
    private Long id;
    private String title;
    private String subtitle;
    private Long categoryId;
    private Integer rootCategoryId;
    private Boolean online;
    private String price;
    private Long sketchSpecId;
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Boolean isTest;
//    private Long spuThemeImg;
    private String forThemeImg;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="spuId")
    private  List<SpuDetailImg> spuDetailImgList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="spuId")
    private  List<SpuImg> spuImgList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="spuId")
    private  List<Sku> skuList;

}
