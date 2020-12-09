package com.lin.missyou.service;

import com.lin.missyou.model.Category;

import java.util.List;
import java.util.Map;

/**
 * @author WeiMao
 * @create 2020-04-29 22:46
 */
public interface CategoryService {

    public Map<Integer, List<Category>> getAll();
}
