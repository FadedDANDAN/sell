package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dto.OrderDto;
import com.wangxiamomei.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageImplTest {

    @Autowired
    private PushMessageImpl pushMessage;

    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() throws Exception{
        OrderDto orderDto = orderService.findOne("1543216161785698624");
        pushMessage.orderStatus(orderDto);
    }

}