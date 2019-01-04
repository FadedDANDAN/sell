package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dao.ProductInfoDao;
import com.wangxiamomei.demo.dataobject.ProductInfo;
import com.wangxiamomei.demo.dto.CartDTO;
import com.wangxiamomei.demo.enums.ProductStatusEnums;
import com.wangxiamomei.demo.enums.ResultEnum;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductInfoDao productInfoDao;
    @Override
    public ProductInfo findById(String id) {
        return productInfoDao.findById(id).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    public void increateStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = productInfoDao.findById(cartDTO.getProductId()).get();
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer num = productInfo.getProductStock() + cartDTO.getProductorQuantity();
            productInfo.setProductStock(num);
            productInfoDao.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void outcreateStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList){
           ProductInfo productInfo =  productInfoDao.findById(cartDTO.getProductId()).get();
           if (productInfo == null){
               throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
           }
          Integer num = productInfo.getProductStock() - cartDTO.getProductorQuantity();
           if (num < 0){
               throw new SellException(ResultEnum.PRODUCT_NOT_STATUS);
           }
           productInfo.setProductStock(num);
           productInfoDao.save(productInfo);
        }

    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoDao.findById(productId).get();
        if (productInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.productStatusEnums() == ProductStatusEnums.UP){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnums.UP.getCode());
        productInfoDao.save(productInfo);
        return productInfoDao.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDao.findById(productId).get();
        if (productInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.productStatusEnums() == ProductStatusEnums.DOWN){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnums.DOWN.getCode());
        productInfoDao.save(productInfo);
        return productInfoDao.save(productInfo);
    }
}
