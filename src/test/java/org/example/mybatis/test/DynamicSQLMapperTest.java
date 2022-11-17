package org.example.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.DynamicSQLMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

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
}
