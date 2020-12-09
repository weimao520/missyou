package com.lin.missyou.api.v1;

import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Spu;
import com.lin.missyou.service.SpuService;
import com.lin.missyou.util.CommonUtil;
import com.lin.missyou.vo.PagingDozer;
import com.lin.missyou.vo.SpuSimplifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

/**
 * @author WeiMao
 * @create 2020-04-27 13:14
 */

@RestController
@RequestMapping("spu")
public class SpuController {


    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = this.spuService.getSpu(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start, @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> latestPagingSpu = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        PagingDozer<Spu, SpuSimplifyVO> dozer = new PagingDozer<>(latestPagingSpu, SpuSimplifyVO.class);

        return dozer;
    }

    @GetMapping("by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategory(@PathVariable @Positive(message = "{id.positive}") Long id,
                                                         @RequestParam(name = "is_root", defaultValue = "false") Boolean isRoot,
                                                         @RequestParam(name = "start", defaultValue = "0") Integer start,
                                                         @RequestParam(name = "count", defaultValue = "10") Integer count) {
        PageCounter counter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> spuPage = this.spuService.getByCategory(id, isRoot, counter.getPage(), counter.getCount());

        return new PagingDozer<>(spuPage, SpuSimplifyVO.class);
    }
}
