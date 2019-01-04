package com.wangxiamomei.demo.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class ProductFrom {
    /*商品id*/
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


    /*类目编号*/
    private Integer categoryType;
}
