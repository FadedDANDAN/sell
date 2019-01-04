package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dataobject.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImpTest {

    private final String openid="123456789";

    @Autowired
    private SellerServiceImp sellerServiceImp;

    @Test
    public void findsellerInfobyopenid() {
        SellerInfo sellerInfo = sellerServiceImp.findsellerInfobyopenid(openid);
        Assert.assertNotNull(sellerInfo);
    }
}