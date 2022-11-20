package org.example.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.DynamicSQLMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(null,"admin",23,"male");
        List<Emp> empByConditions = mapper.getEmpByConditions(emp);
        empByConditions.forEach(System.out::println);
    }
    @Test
    public void testInsertMultiEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp=new Emp(null,"admin",23,"male");
        Emp emp2=new Emp(null,"admin2",23,"male");
        Emp emp3=new Emp(null,"admin3",23,"male");
        List<Emp> emps = Arrays.asList(emp, emp2, emp3);
        mapper.insertMoreEmp(emps);
    }
    @Test
    public void testDeleteMultiEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[]  empIds=new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);
    }
}
