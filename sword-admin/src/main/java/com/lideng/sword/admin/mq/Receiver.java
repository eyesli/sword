package com.lideng.sword.admin.mq;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Log4j
@Component
@RabbitListener(queues = "message")
public class Receiver {


    @RabbitHandler
    public void process(String Str) {
        log.info("接收消息："+Str);
        log.info("接收消息时间："+new Date());
    }
}
