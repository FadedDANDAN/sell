package com.wangxiamomei.demo.service;

import com.wangxiamomei.demo.dataobject.ProductInfo;
import com.wangxiamomei.demo.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    /*查询单个商品*/
    ProductInfo findById(String id);

    /*查询所有上线商品*/
    List<ProductInfo> findUpAll();

    /*查询所有商品*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increateStock(List<CartDTO> cartDTOList);

    //减库存
    void outcreateStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo  offSale(String productId);
}
