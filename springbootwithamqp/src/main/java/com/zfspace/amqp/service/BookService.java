package com.zfspace.amqp.service;

import com.zfspace.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author ZF
 * @description
 * @date 2018-06-06 17:06
 */
@Service
public class BookService {

    /**
     * 监听消息方法1
     * @param book
     */
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    /**
     * 监听消息方法2
     * @param message
     */
    @RabbitListener(queues = "atguigu.news")
    public void receiveTwo(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getBody());
    }
}
