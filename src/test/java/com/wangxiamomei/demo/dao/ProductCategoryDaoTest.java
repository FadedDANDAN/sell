package com.wangxiamomei.demo.dao;

import com.wangxiamomei.demo.dataobject.productCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao categoryDao;

    @Test
    public void findByid(){
        Optional<productCategory> category = categoryDao.findById(1);
        System.out.println(category.toString());
    }

    @Test
    public void saveTest(){

       productCategory category = new productCategory("女生最爱",4);
       categoryDao.save(category);

    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,4);
        List<productCategory> result = categoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }


}