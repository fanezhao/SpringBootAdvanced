package com.zfspace.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zfspace.cache.mapper")
@SpringBootApplication
public class SpringbootwithcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwithcacheApplication.class, args);
    }
}
