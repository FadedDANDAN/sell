package com.wangxiamomei.demo.dataobject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wangxiamomei.demo.Utils.EnumUtil;
import com.wangxiamomei.demo.enums.ProductStatusEnums;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /*商品id*/
    @Id
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品价格*/
    private BigDecimal productPrice;

    /*商品库存*/
    private Integer productStock;

    /*商品描述*/
    private String productDescription;

    /*小图*/
    private String productIcon;

    /*商品状态，0已上架，1未上架*/
    private Integer productStatus = ProductStatusEnums.UP.getCode();

    /*类目编号*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnums productStatusEnums(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnums.class);
    }
}
