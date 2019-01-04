package com.wangxiamomei.demo.dao;

import com.wangxiamomei.demo.dataobject.productCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<productCategory,Integer> {
    List<productCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
