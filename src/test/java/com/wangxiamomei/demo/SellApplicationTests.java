package com.wangxiamomei.demo;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

    private Logger logger = LoggerFactory.getLogger(SellApplication.class);

    @Test
    public void contextLoads() {
        String name = "user";
        String password = "123456";
        logger.debug("debug...");
        logger.info("user: {} ,password: {}",name , password);
        logger.error("error....");

    }

}
