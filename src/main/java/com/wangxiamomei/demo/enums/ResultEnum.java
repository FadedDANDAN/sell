package com.wangxiamomei.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARA_ERROR(1,"参数不正确"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_NOT_STATUS(11,"商品不足"),
    ORDERMASTER_NOT_ESIXT(12,"订单不存在"),
    ORDERDETIAL_NOT_DETIAL(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单异常"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单无详情列表"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付错误"),
    CART_EMPTY_ERROR(18,"购车为空"),
    ORDER_OPENID_ERROR(19,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信账号方面错误"),
    ORDER_SUCCESS(21,"订单取消成功"),
    PRODUCT_STATUS_ERROR(22,"商品状态异常"),
    LOGIN_FAIL(23,"登入失败"),
    LOGOUT(24,"登出"),
    PUSH_ERROR(25,"消息推送失败")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
