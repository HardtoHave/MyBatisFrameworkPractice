package org.example.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.EmpMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.pojo.EmpExample;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample empExample=new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("admin").andAgeEqualTo(12);
        empExample.or().andAgeIsNotNull();
        List<Emp> emps = mapper.selectByExample(empExample);
        emps.forEach(System.out::println);
    }
}
