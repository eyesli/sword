package com.lideng.sword.admin.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lideng
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "简单消息发送";
        log.info("简单消息发送时间："+new Date());
        amqpTemplate.convertAndSend("message", context);
        return "发送成功";
    }
}