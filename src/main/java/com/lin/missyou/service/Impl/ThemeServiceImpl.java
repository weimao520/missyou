package com.lin.missyou.service.Impl;

import com.lin.missyou.model.Theme;
import com.lin.missyou.repository.ThemeRepository;
import com.lin.missyou.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author WeiMao
 * @create 2020-04-30 17:54
 */
@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;
    @Override
    public List<Theme> findByNames(List<String> nameList) {

        return this.themeRepository.findByNames(nameList);
    }

    @Override
    public Optional<Theme> findByName(String name){
        return themeRepository.findByName(name);
    }

}
