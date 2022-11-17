package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    Emp getEmpByEmpId(@Param("empId") Integer empId);
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
    Emp getEmpAndDeptByEmpStepOne (@Param("empId") Integer empId);
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);
}
