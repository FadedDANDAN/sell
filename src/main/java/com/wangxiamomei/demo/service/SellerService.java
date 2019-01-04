package com.wangxiamomei.demo.service;

import com.wangxiamomei.demo.dataobject.SellerInfo;

public interface SellerService {

    /*通过openid查询*/
    SellerInfo findsellerInfobyopenid(String openid);

}
