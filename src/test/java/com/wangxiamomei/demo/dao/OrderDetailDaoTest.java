package com.wangxiamomei.demo.dao;

import com.wangxiamomei.demo.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("123");
        orderDetail.setProductName("钢管鸡");
        orderDetail.setProductPrice(new BigDecimal(49));
        orderDetail.setProductQuantity(200);

        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> result = orderDetailDao.findByOrderId("1234567");
        Assert.assertNotEquals(0,result.size());


    }
}