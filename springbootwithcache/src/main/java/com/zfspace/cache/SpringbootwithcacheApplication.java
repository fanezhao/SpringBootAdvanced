package com.zfspace.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.zfspace.cache.mapper")
@SpringBootApplication
@EnableCaching  // 开启缓存
public class SpringbootwithcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwithcacheApplication.class, args);
    }
}
