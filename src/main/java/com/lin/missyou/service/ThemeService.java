package com.lin.missyou.service;

import com.lin.missyou.model.Theme;

import java.util.List;
import java.util.Optional;

/**
 * @author WeiMao
 * @create 2020-04-30 17:54
 */
public interface ThemeService {
    List<Theme> findByNames(List<String> nameList);

    Optional<Theme> findByName(String name);
}
