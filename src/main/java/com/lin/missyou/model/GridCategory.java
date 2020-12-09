package com.lin.missyou.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author WeiMao
 * @create 2020-04-30 16:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Where(clause = "delete_time is null")
public class GridCategory  extends BaseEntity{
    private static final long serialVersionUID = -2861172659456239839L;
    @Id
    private Long id;
    private String title;
    private String img;
    private String name;

    private Long categoryId;
    private Long rootCategoryId;


}
