package com.wangxiamomei.demo.Controller;

import com.wangxiamomei.demo.Utils.ResultVOUtil;
import com.wangxiamomei.demo.VO.ResultVO;
import com.wangxiamomei.demo.converter.OrderForm2OderDtoConverter;
import com.wangxiamomei.demo.dto.OrderDto;
import com.wangxiamomei.demo.enums.ResultEnum;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.form.OrderForm;
import com.wangxiamomei.demo.service.BuyerService;
import com.wangxiamomei.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确 orderForm={}" ,orderForm);
            throw new SellException(ResultEnum.PARA_ERROR.getCode()
                ,bindingResult.getFieldError().getDefaultMessage()
            );
        }


        OrderDto orderDto = OrderForm2OderDtoConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMPTY_ERROR);
        }

        OrderDto createorderdato = orderService.create(orderDto);
        Map<String,String> map = new HashMap<>();
        map.put("orderid",createorderdato.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表

    @GetMapping("/list")
    public ResultVO<List<OrderDto>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARA_ERROR);
        }

        PageRequest request = PageRequest.of(page, size);
        Page<OrderDto> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDto> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDto orderDto = buyerService.findorderOne(openid, orderId);
        return ResultVOUtil.success(orderDto);
    }

    //取消订单
    @PostMapping("/cancle")
    public ResultVO<OrderDto> cancle(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {

       buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();

    }


}
