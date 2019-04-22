package com.wangxiamomei.demo.service;

import com.wangxiamomei.demo.dto.OrderDto;

public interface PushMessage {
    /*
    * 订单状态变更消息
    * */

    void orderStatus(OrderDto orderDto);
}
