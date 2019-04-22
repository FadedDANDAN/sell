package com.wangxiamomei.demo.service.impl;

import com.lly835.bestpay.rest.type.Get;
import com.wangxiamomei.demo.config.WechatAccountConfig;
import com.wangxiamomei.demo.config.WechatMpConfig;
import com.wangxiamomei.demo.dto.OrderDto;
import com.wangxiamomei.demo.enums.ResultEnum;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PushMessageImpl implements PushMessage {
    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public void orderStatus(OrderDto orderDto) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(wechatAccountConfig.getTemplateId().get("orderStatus"));
        wxMpTemplateMessage.setToUser(orderDto.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
          new WxMpTemplateData("first","亲，请记得收货。"),
          new WxMpTemplateData("keyword1","微信点餐"),
          new WxMpTemplateData("keyword2","12345678910"),
          new WxMpTemplateData("keyword3",orderDto.getOrderId()),
          new WxMpTemplateData("keyword4",orderDto.orderStatusEnum().getMessage()),
          new WxMpTemplateData("keyword5","Y" + orderDto.getOrderAmount()),
        new WxMpTemplateData("remake","谢谢惠顾！")
        );
        wxMpTemplateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        }catch (WxErrorException e){
            log.error("【微信模板消息】发送失败，{}" ,e);
        }

    }
}
