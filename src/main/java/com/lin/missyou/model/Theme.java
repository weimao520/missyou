package com.lin.missyou.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-30 17:15
 */
@Data
@Entity
@Where(clause = "delete_time is null")
public class Theme extends BaseEntity {
    private static final long serialVersionUID = 4340986819032171388L;
    @Id
    private Long id;
    private String title;
    private String description;
    private String name;
    private String tplName;

    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;

    @ManyToMany
    @JoinTable(name="theme_spu",joinColumns = @JoinColumn(name = "theme_id "),
    inverseJoinColumns = @JoinColumn(name="spu_id"))
    private List<Spu> spuList;
}
