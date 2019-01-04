package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dto.OrderDto;
import com.wangxiamomei.demo.enums.ResultEnum;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.service.BuyerService;
import com.wangxiamomei.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findorderOne(String openid, String orderid) {
        OrderDto orderDto = checkownOrder(openid,orderid);
        return orderDto;
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderid) {
        OrderDto orderDto = checkownOrder(openid,orderid);
        if (orderDto == null){
            log.error("【取消订单】 查不到该订单 orderid={}",orderid);
            throw new SellException(ResultEnum.ORDERMASTER_NOT_ESIXT);
        }
        return orderService.cancle(orderDto);
    }

    private OrderDto checkownOrder(String openid, String orderid) {
        OrderDto orderDto = orderService.findOne(orderid);

        //判断是否是自己的订单
        if (!orderDto.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】 订单openid不符 openid = {}", openid);
            throw new SellException(ResultEnum.ORDER_OPENID_ERROR);
        }
        return orderDto;
    }
}
