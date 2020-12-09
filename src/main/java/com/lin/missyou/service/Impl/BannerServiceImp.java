package com.lin.missyou.service.Impl;

import com.lin.missyou.model.Banner;
import com.lin.missyou.repository.BannerRepository;
import com.lin.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WeiMao
 * @create 2020-04-25 0:01
 */
@Service
public class BannerServiceImp implements BannerService {

    @Autowired
    private BannerRepository repository;

    @Override
    public Banner findByName(String name) {


        return repository.findOneByName(name);
    }
}
