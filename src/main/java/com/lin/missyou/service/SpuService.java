package com.lin.missyou.service;

import com.lin.missyou.model.Spu;
import org.springframework.data.domain.Page;

/**
 * @author WeiMao
 * @create 2020-04-27 13:18
 */
public interface SpuService {
    Spu getSpu(Long id);

    Page<Spu> getLatestPagingSpu(Integer page, Integer size);

    Page<Spu> getByCategory(Long id,Boolean isRoot,Integer pageNum,Integer size);
}
