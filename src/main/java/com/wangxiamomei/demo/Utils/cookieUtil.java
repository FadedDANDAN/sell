package com.wangxiamomei.demo.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class cookieUtil {
    public static void  set(HttpServletResponse response,
                            String name,
                            String vaule,
                            int maxAge){
        Cookie cookie = new Cookie(name,vaule);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void  get(){}
}
