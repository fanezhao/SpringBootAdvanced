package com.zfspace.cache.mapper;

import com.zfspace.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author ZF
 * @description
 * @date 2018-05-22 20:01
 */
@Mapper
public interface EmployerMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void delEmp(Integer id);

    @Insert("insert into employee(lastName, email, gender, d_id) values (#{lastName}, #{email}, #{gender}, #{dId})")
    void insertEmp(Employee employee);

    @Select("select * from employee where lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
