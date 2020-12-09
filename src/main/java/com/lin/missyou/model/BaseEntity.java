package com.lin.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author WeiMao
 * @create 2020-04-26 21:18
 */
@Getter
@Setter
@MappedSuperclass
public  abstract   class BaseEntity  implements Serializable {

    private static final long serialVersionUID = -6312799559246789919L;


//    不返回给前端
    @JsonIgnore
    private   Date createTime;
    @JsonIgnore
    private  Date updateTime;
    @JsonIgnore
    private  Date deleteTime;

}
