package org.example.mybatis.mapper;

import org.example.mybatis.pojo.Emp;

import java.util.List;

public interface DynamicSQLMapper {
    List<Emp> getEmpByConditions(Emp emp);
}
