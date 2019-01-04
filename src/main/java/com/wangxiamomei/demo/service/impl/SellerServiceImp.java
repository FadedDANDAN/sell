package com.wangxiamomei.demo.service.impl;

import com.wangxiamomei.demo.dao.SellerInfoDao;
import com.wangxiamomei.demo.dataobject.SellerInfo;
import com.wangxiamomei.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
public class SellerServiceImp implements SellerService {
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findsellerInfobyopenid(String openid) {
        SellerInfo sellerInfo = sellerInfoDao.findByOpenid(openid);
        return sellerInfo;
    }
}
