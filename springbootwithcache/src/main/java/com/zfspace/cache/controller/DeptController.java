package com.zfspace.cache.controller;

import com.zfspace.cache.bean.Department;
import com.zfspace.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZF
 * @description
 * @date 2018-06-05 14:36
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable Integer id) {
        return deptService.getDeptById(id);
    }
}
