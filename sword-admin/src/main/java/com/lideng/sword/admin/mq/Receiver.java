package com.lideng.sword.admin.mq;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "message")
public class Receiver {
    Logger logger = Logger.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String Str) {
        logger.info("接收消息："+Str);
        logger.info("接收消息时间："+new Date());
    }
}
