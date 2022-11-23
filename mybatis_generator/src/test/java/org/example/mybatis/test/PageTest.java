package org.example.mybatis.test;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.EmpMapper;
import org.example.mybatis.pojo.Emp;
import org.example.mybatis.pojo.EmpExample;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(1,1);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println );
    }
}
