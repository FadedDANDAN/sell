package com.wangxiamomei.demo.Controller;


import com.wangxiamomei.demo.Utils.cookieUtil;
import com.wangxiamomei.demo.config.ProjectUrlConfig;
import com.wangxiamomei.demo.constant.CookieConstant;
import com.wangxiamomei.demo.constant.RedisConstant;
import com.wangxiamomei.demo.dataobject.SellerInfo;
import com.wangxiamomei.demo.enums.ResultEnum;
import com.wangxiamomei.demo.service.SellerService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String,Object> map){
        //1.openid去和数据库的比较
        SellerInfo sellerInfo = sellerService.findsellerInfobyopenid(openid);
        if (sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        //2.设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);
        //3.设置token至cookie
        cookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return  new ModelAndView("redirect:" + projectUrlConfig.getSell() +"/sell/seller/order/list");
    }

    @RequestMapping("/logout")
    public void logout(){

    }

}
