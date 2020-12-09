package com.lin.missyou.service.Impl;

import com.lin.missyou.model.Spu;
import com.lin.missyou.repository.SpuRepository;
import com.lin.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author WeiMao
 * @create 2020-04-27 13:18
 */

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuRepository spuRepository;

    @Override
     public Spu getSpu(Long id){
        return    this.spuRepository.findOneById(id);
    }

    @Override
    public Page<Spu> getLatestPagingSpu(Integer page, Integer size) {

        Pageable pageRequest = PageRequest.of(page, size, Sort.by("createTime").descending());

        return this.spuRepository.findAll(pageRequest);
    }

    @Override
    public Page<Spu> getByCategory(Long id, Boolean isRoot, Integer pageNum, Integer size) {

        Pageable page = PageRequest.of(pageNum, size);
        if (isRoot) {
          return   this.spuRepository.findByRootCategoryIdOrderByCreateTime(id, page);
        }else{
           return this.spuRepository.findByCategoryIdOrderByCreateTimeDesc(id, page);
        }

    }
}
