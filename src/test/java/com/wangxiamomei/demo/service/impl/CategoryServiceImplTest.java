package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dao.ProductCategoryDao;
import com.wangxiamomei.demo.dataobject.productCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findById() {

        productCategory productcategory = categoryService.findById(1);
        Assert.assertEquals(new Integer(1),productcategory.getCategoryId());

    }

    @Test
    public void findAll() {
        List<productCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<productCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(2,13));
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void save() {

        productCategory category = new productCategory("老年专享",7);
        productCategory result = categoryService.save(category);
        Assert.assertNotNull(result);

    }
}