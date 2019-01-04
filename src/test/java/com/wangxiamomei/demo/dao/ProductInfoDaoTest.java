package com.wangxiamomei.demo.dao;

import com.wangxiamomei.demo.dataobject.ProductInfo;
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
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void save(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("钢管鸡");
        productInfo.setProductPrice(new BigDecimal(49.00));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("会跳舞的鸡");
        productInfo.setProductIcon("http://123213.img");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        productInfoDao.save(productInfo);



    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> list = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());

    }
}