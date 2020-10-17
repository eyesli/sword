package com.lideng.sword.admin.controller;

import com.lideng.sword.admin.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/123")
    public String submit(){
        logger.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        logger.info("end submit");

        return "success";
    }
}