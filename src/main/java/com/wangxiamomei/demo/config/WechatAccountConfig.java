package com.wangxiamomei.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /*
    * 公众平台id
    * */
    private String mpAppId;

    /*
    * 公众平台密钥
    * */
    private String mpAppSecret;

    /**
     * 开放平台id
     */
    private String openAppId;

    /**
     * 开放平台密钥
     */
    private String openAppSecret;

    /*
    * 微信消息推送服务
    * */
    private Map<String,String> templateId;
}
