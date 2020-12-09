package com.lin.missyou.repository;

import com.lin.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WeiMao
 * @create 2020-04-27 13:20
 */

public interface SpuRepository extends JpaRepository<Spu, Long> {

    /**
     *
     * @param id
     * @return
     */
    Spu findOneById(Long id);

    Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long id, Pageable pageable);

    Page<Spu> findByRootCategoryIdOrderByCreateTime(Long id, Pageable pageable);
}
