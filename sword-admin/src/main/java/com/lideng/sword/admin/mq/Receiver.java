package com.lideng.sword.admin.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RabbitListener(queues = "message")
public class Receiver {


    @RabbitHandler
    public void process(String Str) {
        log.info("接收消息："+Str);
        log.info("接收消息时间："+new Date());
    }
}
