package com.wangxiamomei.demo.dto;

import lombok.Data;

@Data
public class CartDTO {

    private String productId;

    private Integer productorQuantity;

    public CartDTO(String productId, Integer productorQuantity) {
        this.productId = productId;
        this.productorQuantity = productorQuantity;
    }
}
