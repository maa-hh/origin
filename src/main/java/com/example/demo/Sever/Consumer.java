package com.example.demo.Sever;

import com.example.demo.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    @SendTo(RabbitMQConfig.QUEUE_NAME2)
    public String receiveMessage(String msg) {
        System.out.println("收到消息：" + msg);
        return msg;
    }
}

