package com.zfspace.cache;

import com.zfspace.cache.bean.Employee;
import com.zfspace.cache.mapper.EmployerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootwithcacheApplicationTests {

    @Autowired
    private EmployerMapper employerMapper;

    // 操作key-value都是字符串
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 操作key-value都是对象的
    @Autowired
    private RedisTemplate redisTemplate;

    // 自定义序列化器的redisTemplate
    @Autowired
    private RedisTemplate empRedisTemplate;

    /**
     * 测试redis:
     *
     */
    @Test
    public void testStringRedis() {
        // 保存数据
        // stringRedisTemplate.opsForValue().append("msg", "hello world");
        // 获取数据
        // System.out.println(stringRedisTemplate.opsForValue().get("msg"));
        stringRedisTemplate.opsForValue();
        stringRedisTemplate.opsForHash();
        stringRedisTemplate.opsForList();
        stringRedisTemplate.opsForSet();
        stringRedisTemplate.opsForZSet();
    }

    @Test
    public void testRedis() {
        // 如果保存对象，默认使用jdk序列化机制，序列化后的数据保存到redis
        // redisTemplate.opsForValue().set("emp", employerMapper.getEmpById(1));

        // 使用自定义序列化器
        empRedisTemplate.opsForValue().set("emp", employerMapper.getEmpById(1));
    }

    @Test
    public void contextLoads() {

        Employee empById = employerMapper.getEmpById(1);
        System.out.println(empById);
    }

}
