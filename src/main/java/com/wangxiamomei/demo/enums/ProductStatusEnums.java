package com.wangxiamomei.demo.enums;


import lombok.Getter;

/*
* s商品状态
*
* */
@Getter
public enum ProductStatusEnums implements CodeEnum{

    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
