package com.wangxiamomei.demo.service;

import com.wangxiamomei.demo.dataobject.productCategory;

import java.util.List;

public interface CategoryService {

    productCategory findById(Integer id);

    List<productCategory> findAll();

    List<productCategory> findByCategoryTypeIn(List<Integer> categoryType);

    productCategory save(productCategory category);
}
