package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

public interface CacheMapper {
    Emp getEmpId(@Param("empId") Integer empId);
}
