package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dao.ProductCategoryDao;
import com.wangxiamomei.demo.dataobject.productCategory;
import com.wangxiamomei.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDao categoryDao;

    @Override
    public productCategory findById(Integer id) {
        return categoryDao.findById(id).get();
    }

    @Override
    public List<productCategory> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<productCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return categoryDao.findByCategoryTypeIn(categoryType);
    }

    @Override
    public productCategory save(productCategory category) {
        return categoryDao.save(category);
    }
}
