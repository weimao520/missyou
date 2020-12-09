package com.lin.missyou.vo;

import com.lin.missyou.model.Category;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WeiMao
 * @create 2020-04-29 22:01
 */
@Data
public class CategoriesAllVO {

    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;


    public CategoriesAllVO(Map<Integer, List<Category>> map) {
          this.roots=map.get(1).stream().map(CategoryPureVO::new).collect(Collectors.toList());
          this.subs=map.get(2).stream().map(CategoryPureVO::new).collect(Collectors.toList());
    }
}
