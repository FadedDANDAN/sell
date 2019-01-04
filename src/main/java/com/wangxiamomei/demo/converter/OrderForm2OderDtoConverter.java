package com.wangxiamomei.demo.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wangxiamomei.demo.dataobject.OrderDetail;
import com.wangxiamomei.demo.dto.OrderDto;
import com.wangxiamomei.demo.enums.ResultEnum;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.form.OrderForm;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OderDtoConverter {

    public static OrderDto converter(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】 错误，string={}" ,orderForm.getItems());
            throw new SellException(ResultEnum.PARA_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;
    }

}
