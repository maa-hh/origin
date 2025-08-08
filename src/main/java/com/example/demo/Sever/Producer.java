package com.example.demo.Sever;

import com.example.demo.Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                msg
        );
        System.out.println("发送消息：" + msg);
    }
    /** Topic 模糊匹配发送 ,会发给可匹配上的绑定队列*/
    public void sendTopic(String key, String msg) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME2,
                key,
                msg
        );
        System.out.println("[Topic] Sent [" + key + "]: " + msg);
    }
}

