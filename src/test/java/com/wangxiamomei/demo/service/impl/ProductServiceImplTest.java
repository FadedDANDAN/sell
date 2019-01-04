package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dataobject.ProductInfo;
import com.wangxiamomei.demo.enums.ProductStatusEnums;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findById() {
        ProductInfo productInfo = productService.findById("123");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> productInfos = productService.findAll(request);
        System.out.println(productInfos.getTotalElements());

    }

    @Test
    public void save() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("456");
        productInfo.setProductName("清蒸鲤鱼");
        productInfo.setProductPrice(new BigDecimal(49.00));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("一口回到18岁");
        productInfo.setProductIcon("http://15165.img");
        productInfo.setProductStatus(ProductStatusEnums.DOWN.getCode());
        productInfo.setCategoryType(13);

        ProductInfo result = productService.save(productInfo);

        Assert.assertNotNull(result);

    }

    @Test
    public void onsale(){
        ProductInfo result = productService.onSale("123");
        Assert.assertNotEquals(ProductStatusEnums.UP.getMessage(),result.productStatusEnums());
    }

    @Test
    public void offsale(){
        ProductInfo result = productService.offSale("123");
        Assert.assertNotEquals(ProductStatusEnums.DOWN.getMessage(),result.productStatusEnums());
    }
}