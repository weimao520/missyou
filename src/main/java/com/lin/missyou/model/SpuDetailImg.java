package com.lin.missyou.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author WeiMao
 * @create 2020-04-27 17:24
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class SpuDetailImg extends BaseEntity {
    private static final long serialVersionUID = 6799166451075823199L;
    @Id
    private Long id;
    private String img;
    private Long spuId;
    private Long index;


}
