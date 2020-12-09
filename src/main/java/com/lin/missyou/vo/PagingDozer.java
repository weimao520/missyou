package com.lin.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-27 21:04
 */
public class PagingDozer<T, K> extends Paging {

    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> pageT, Class<K> classK) {
        this.initPageParameters(pageT);

        List<T> tList = pageT.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> vo = new ArrayList<>();
        tList.forEach(r -> {
            K map = mapper.map(r, classK);
            vo.add(map);
        });
        this.setItems(vo);
    }
}
