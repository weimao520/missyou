package com.lin.missyou.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lin.missyou.util.GenericAndJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-27 17:24
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Sku  extends BaseEntity{
    private static final long serialVersionUID = 8544524438182184229L;
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;



    private String specs;
    private String code;
    private Long stock;
    private Long categoryId;
    private Long  rootCategoryId;


    public void setSpecs(List<Spec> specs) {
        if (specs.isEmpty()) {
            return;
        }
        GenericAndJson.objectToJson(specs);
    }

    public List<Spec> getSpecs(){
        if (null == this.specs) {
            return Collections.emptyList();
        }

        return  GenericAndJson.jsonToObject(this.specs,new TypeReference<List<Spec>>(){});

    }


}
