package com.wangxiamomei.demo.dao;

import com.wangxiamomei.demo.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID = "120120";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("飞");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("火星");
        orderMaster.setBuyerOpenid("120120");
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = orderMasterDao.save(orderMaster);

        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() throws  Exception{

        PageRequest pageRequest = PageRequest.of(0,1);

        Page<OrderMaster> orderMasters = orderMasterDao.findByBuyerOpenid(OPENID,pageRequest);

        System.out.println(orderMasters.getTotalElements());

    }
}



