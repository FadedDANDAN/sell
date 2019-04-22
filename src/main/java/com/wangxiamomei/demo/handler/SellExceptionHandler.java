package com.wangxiamomei.demo.handler;

import com.wangxiamomei.demo.config.ProjectUrlConfig;
import com.wangxiamomei.demo.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登入异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    //todo
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
              .concat("/sell/seller/login"));
    }
}
