package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.Emp;

import java.util.List;

public interface DynamicSQLMapper {
    List<Emp> getEmpByConditions(Emp emp);
    List<Emp> getEmpByChoose(Emp emp);
    void insertMoreEmp(@Param("emps") List<Emp> emps);
    void deleteMoreEmp(@Param("empIds")Integer[] empIds);

}
