package com.zfspace.amqp.bean;

import java.io.Serializable;

/**
 * @author ZF
 * @description
 * @date 2018-06-06 16:45
 */
public class Book implements Serializable {

    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
