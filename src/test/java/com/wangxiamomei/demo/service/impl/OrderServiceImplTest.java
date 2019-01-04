package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dataobject.OrderDetail;
import com.wangxiamomei.demo.dto.OrderDto;
import com.wangxiamomei.demo.enums.OrderStatusEnum;
import com.wangxiamomei.demo.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private String OPENID = "112112";

    private String ORDERID ="1542694756562772494";

    @Test
    public void create() {
        OrderDto orderDTO = new OrderDto();
        orderDTO.setBuyerName("飞飞");
        orderDTO.setBuyerAddress("水星");
        orderDTO.setBuyerPhone("123456789011");
        orderDTO.setBuyerOpenid(OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("456");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDto result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDto orderDto = orderService.findOne(ORDERID);
        log.info("【查询单个订单】result={}", orderDto);
        Assert.assertNotNull(orderDto);
    }

    @Test
    public void findList() {

        PageRequest request = PageRequest.of(0,2);
        Page<OrderDto> orderDtos = orderService.findList(OPENID,request);
        Assert.assertNotEquals(0,orderDtos.getSize());

    }

    @Test
    public void cancle() {
        OrderDto orderDTO = orderService.findOne(ORDERID);
        OrderDto result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDto orderDTO = orderService.findOne(ORDERID);
        OrderDto result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void pay() {
        OrderDto orderDTO = orderService.findOne(ORDERID);
        OrderDto result = orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void findAll(){
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDto> orderDtoPage = orderService.findList(request);
       // Assert.assertNotEquals(0,orderDtoPage.getTotalElements());
        Assert.assertTrue("查询所有订单列表",orderDtoPage.getTotalElements() > 0);
    }
}