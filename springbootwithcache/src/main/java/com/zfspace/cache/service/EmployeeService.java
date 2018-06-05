package com.zfspace.cache.service;

import com.zfspace.cache.bean.Employee;
import com.zfspace.cache.mapper.EmployerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author ZF
 * @description
 * @date 2018-05-22 21:33
 */
@CacheConfig(cacheNames = "emp", cacheManager = "empRedisCacheManager")
@Service
public class EmployeeService {

    @Autowired
    private EmployerMapper employerMapper;

    /**
     * 将方法的缓存结果进行缓存， 下次如果查询同样的数据，直接从缓存中获取
     * 核心属性：
     *     1、cacheNames/values: 指定缓存组件的名子
     *     2、Key: 缓存key。默认使用的是方法参数值，例如：1-方法的返回值
     *     3、keyGenerator: key生成器，可以自己指定key的生成器的组件id
     * 另外：key和keyGenerator二选一
     *     4、CacheManager 指定缓存管理器或者指定解析器cacheResolver，二选一
     *     5、condition 指定符合条件的情况下缓存，例如：condition = "#id>1"
     *     6、unless 否定缓存，当unless条件为true时，结果不缓存。可以获取结果进行判断，例如：unless = "#result == null"
     *     7、sync 是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp"/*, keyGenerator = "myKeyGenerator", condition = "#id>1", unless = "#a0==2"*/)
    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "号员工");
        return employerMapper.getEmpById(id);
    }

    /**
     * @CachePut 即调用方法又更新缓存，同步更新缓存
     * 修改数据库，同时更新缓存
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法缓存起来
     *
     *
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("更新员工" + employee);
        employerMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict 清除缓存
     * @param id
     */
    @CacheEvict(value = "emp", beforeInvocation = true/*allEntries = true*/ /*key = "#id"*/)
    public void deleteEmp(Integer id) {
        System.out.println("删除一个员工 " + id);
        // employerMapper.delEmp(id);
        int i = 1 / 0;
    }


    /**
     * 为什么二次访问此接口还是会再次查询数据库？
     * 因为注解中有 @CachePut所有方法是必须执行的
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        System.out.println("根据姓名查询一个员工 " + lastName);
        return employerMapper.getEmpByLastName(lastName);
    }
}
