package com.wangxiamomei.demo.service;

import com.wangxiamomei.demo.dto.OrderDto;

public interface BuyerService {

    //查询一个订单
    OrderDto findorderOne(String openid,String orderid);

    //取消订单
    OrderDto cancelOrder(String openid,String orderid);
}
