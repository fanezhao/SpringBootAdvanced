package com.zfspace.cache.service;

import com.zfspace.cache.bean.Employee;
import com.zfspace.cache.mapper.EmployerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZF
 * @description
 * @date 2018-05-22 21:33
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployerMapper employerMapper;

    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "号员工");
        return employerMapper.getEmpById(id);
    }
}
