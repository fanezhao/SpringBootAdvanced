package com.zfspace.cache.service;

import com.zfspace.cache.bean.Department;
import com.zfspace.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author ZF
 * @description
 * @date 2018-06-05 14:38
 */
@CacheConfig(cacheNames = "dept", cacheManager = "deptRedisCacheManager")
@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    // 指定缓存管理器
    @Qualifier("deptRedisCacheManager")
    @Autowired
    private RedisCacheManager deptRedisCacheManager;

    /**
     * 序列化成json时 无论对象是什么都可以缓存起来
     * 第二次从缓存中查询就不能反序列化回来；
     * 存的是dept数据源；CacheManager 使用的是new Jackson2JsonRedisSerializer<>(Employee.class))操作redis，只能将Employee反序列化
     * @param id
     * @return
     */
    // @Cacheable("dept")
    // public Department getDeptById(Integer id) {
    //     System.out.println("查询部门：" + id);
    //     return departmentMapper.getDeptById(id);
    // }

    /**
     * 使用缓存管理器得到缓存
     * @param id
     * @return
     */
    public Department getDeptById(Integer id) {
        System.out.println("查询部门：" + id);
        Department dept = departmentMapper.getDeptById(id);
        // 获取某个缓存
        Cache cache = deptRedisCacheManager.getCache("dept");
        cache.put("dept -> 1", dept);
        return dept;
    }
}
