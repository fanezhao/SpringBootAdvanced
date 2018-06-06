package com.zfspace.amqp.springbootwithamqp;

import com.zfspace.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootwithamqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        // amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        // System.out.println("创建完成");

        // amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));

        // 追寻绑定规则
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",
                Binding.DestinationType.QUEUE, "amqpAdmin.exchange", "amqp.hello", null));
    }


    /**
     * 发送消息（点对点）
     */
    @Test
    public void sendMessageOfDirect() {
        // Message 需要自己构造，定义消息体和消息头
        // rabbitTemplate.send(exchange, routingKey, message);

        // object 默认当成消息体，只需要传入要改善的对象，自动序列化发送给RabbitMQ
        // rabbitTemplate.convertAndSend(exchange, routingKey, object);
        // Map<String, Object> map = new HashMap<>();
        // map.put("msg", "this is a message");
        // map.put("date", Arrays.asList("hello", "world", 1, true));
        // 对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("《thinking in java》", "Bruce Eckel"));
    }

    /**
     * 发送消息（广播）
     */
    @Test
    public void sendMessageOfFanout() {
        // Message 需要自己构造，定义消息体和消息头
        // rabbitTemplate.send(exchange, routingKey, message);

        // object 默认当成消息体，只需要传入要改善的对象，自动序列化发送给RabbitMQ
        // rabbitTemplate.convertAndSend(exchange, routingKey, object);
        // Map<String, Object> map = new HashMap<>();
        // map.put("msg", "this is a message");
        // map.put("date", Arrays.asList("hello", "world", 1, true));
        // 对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.fanout", "atguig", new Book("《thinking in java》", "Bruce Eckel"));
    }

    /**
     * 发送消息（topic）
     */
    @Test
    public void sendMessageOfTopic() {
        // Message 需要自己构造，定义消息体和消息头
        // rabbitTemplate.send(exchange, routingKey, message);

        // object 默认当成消息体，只需要传入要改善的对象，自动序列化发送给RabbitMQ
        // rabbitTemplate.convertAndSend(exchange, routingKey, object);
        // Map<String, Object> map = new HashMap<>();
        // map.put("msg", "this is a message");
        // map.put("date", Arrays.asList("hello", "world", 1, true));
        // 对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.topic", "hello.news", new Book("《thinking in java》", "Bruce Eckel"));
    }

    /**
     * 接收消息
     */
    @Test
    public void receiveMessage() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
