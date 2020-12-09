package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Category;
import com.lin.missyou.model.GridCategory;
import com.lin.missyou.service.GridCategoryService;
import com.lin.missyou.service.Impl.CategoryServiceImpl;
import com.lin.missyou.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author WeiMao
 * @create 2020-04-29 21:36
 */
@RequestMapping("category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private GridCategoryService gridCategoryService;

    @GetMapping("all")
    public CategoriesAllVO getAll() {
        Map<Integer, List<Category>> categories = categoryService.getAll();
        return new CategoriesAllVO(categories);
    }


    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryList(){
        List<GridCategory> gridCategoryList = this.gridCategoryService.getGridCategoryList();
        if (gridCategoryList.isEmpty()) {
            throw  new NotFoundException(30009);
        }
        return gridCategoryList;
    }


}
