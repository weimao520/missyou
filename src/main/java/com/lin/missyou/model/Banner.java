package com.lin.missyou.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-26 20:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Where(clause = "delete_time is null")
public class Banner extends BaseEntity   {
    private static final long serialVersionUID = 7402098341663411351L;


    @Id
    private Long id;
    private String name;
    private String description;

    private String title;
    private String img;

    @OneToMany
    @JoinColumn(name = "bannerId")
    private  List<BannerItem> items;
}
