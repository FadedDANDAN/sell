/*
package com.wangxiamomei.demo.aspect;

import com.wangxiamomei.demo.Utils.cookieUtil;
import com.wangxiamomei.demo.constant.CookieConstant;
import com.wangxiamomei.demo.constant.RedisConstant;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.exception.SellerAuthorizeException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public * com.wangxiamomei.demo.Controller.Seller*.*(..)) " +
            "&& !execution(public * com.wangxiamomei.demo.Controller.SellerUserController.*(..))")
    public  void verify(){}

    @Before("verify()")
    public  void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = cookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null){
            log.warn("【登入效验】 cookie中查询不到token");
            throw new SellerAuthorizeException();
        }
        //去redis中查询
        String tokenvalue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if (StringUtils.isEmpty(tokenvalue)){
            log.warn("【登入效验】 redis中查询不到token");
            throw new SellerAuthorizeException();
        }

    }

}
*/
