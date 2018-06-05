package com.zfspace.cache.mapper;

import com.zfspace.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ZF
 * @description
 * @date 2018-05-22 20:02
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);
}
