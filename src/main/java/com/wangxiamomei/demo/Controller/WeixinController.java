package com.wangxiamomei.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void  auth(@RequestParam("code") String code){
        log.info("进入访问信息");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx5c78daff57f9832f&secret=eef1905b0f67a0b2fe515581b0fa5f17&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String repsonse = restTemplate.getForObject(url,String.class);
        log.info("response = {}",repsonse);

    }

}
