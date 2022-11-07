package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Dept;

public interface DeptMapper  {
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);
}
