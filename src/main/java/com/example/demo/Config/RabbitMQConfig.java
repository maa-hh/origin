package com.example.demo.Config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // 队列名称
    public static final String QUEUE_NAME = "test.queue";
    public static final String QUEUE_NAME2 = "test.queue2";
    // 交换机名称
    public static final String EXCHANGE_NAME = "test.exchange";
    public static final String EXCHANGE_NAME2 = "test.exchange2";
    // Routing Key
    public static final String ROUTING_KEY = "test.key";
    public static final String ROUTING_KEY2 = "test.key2";

    /**
     * 1. 声明队列
     * durable: 是否持久化（true 表示 RabbitMQ 重启后仍然存在）
     */
    @Bean
    public Queue queue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }
    @Bean
    public Queue queue2() {
        return QueueBuilder.durable(QUEUE_NAME2).build();
    }

    /**
     * 2. 声明 Direct 交换机
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE_NAME2);
    }
    /**
     * 3. 绑定队列到交换机，并指定 Routing Key
     */
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange) {
        //return BindingBuilder.bind(queue2).to(exchange).with(ROUTING_KEY2);
        return BindingBuilder.bind(queue2).to(exchange).with("test.*");
    }
}

