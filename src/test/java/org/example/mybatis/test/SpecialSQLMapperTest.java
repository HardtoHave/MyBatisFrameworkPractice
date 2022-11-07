package org.example.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.mapper.SelectMapper;
import org.example.mybatis.mapper.SpecialSQLMapper;
import org.example.mybatis.pojo.User;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class SpecialSQLMapperTest {
    @Test
     public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        a.forEach(System.out::println);
    }
    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("9,10");
    }
    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user=new User(null,"ming","123456",23,"male","ming@gmail.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
