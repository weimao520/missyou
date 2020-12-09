package com.lin.missyou.vo;

import com.lin.missyou.model.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author WeiMao
 * @create 2020-04-30 14:31
 */
@Data
public class CategoryPureVO {

    private Long id;
    private String name;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;

    public CategoryPureVO(Category category){
        BeanUtils.copyProperties(category,this);
    }

    public CategoryPureVO() {
    }
}
