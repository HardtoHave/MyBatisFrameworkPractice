package org.example.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println );
        System.out.println(page);
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
        System.out.println(empPageInfo);
    }
}
