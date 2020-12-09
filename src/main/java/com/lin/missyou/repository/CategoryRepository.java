package com.lin.missyou.repository;

import com.lin.missyou.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-29 22:02
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);

}
