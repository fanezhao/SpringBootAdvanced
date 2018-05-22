package com.zfspace.cache;

import com.zfspace.cache.bean.Employee;
import com.zfspace.cache.mapper.EmployerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootwithcacheApplicationTests {

    @Autowired
    private EmployerMapper employerMapper;

    @Test
    public void contextLoads() {

        Employee empById = employerMapper.getEmpById(1);
        System.out.println(empById);
    }

}
