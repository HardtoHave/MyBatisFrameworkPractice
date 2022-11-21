package org.example.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.mapper.CacheMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empId = mapper.getEmpId(1);
        System.out.println(empId);
        Emp empId1 = mapper.getEmpId(1);
        System.out.println(empId1);
    }
    @Test
    public void testCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = build.openSession(true);
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp empId = mapper.getEmpId(1);
        System.out.println(empId);
        sqlSession1.close();
        SqlSession sqlSession2 = build.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp empId2 = mapper2.getEmpId(1);
        System.out.println(empId2);
        sqlSession2.close();
    }
}
