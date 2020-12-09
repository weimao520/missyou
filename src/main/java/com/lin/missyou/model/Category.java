package com.lin.missyou.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author WeiMao
 * @create 2020-04-29 22:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public  class Category extends BaseEntity  {
    private static final long serialVersionUID = 6806838834954261122L;

    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;
//    private Boolean online;
//    private Long level;


}
