package org.example.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.mapper.UserMapper;
import org.example.mybatis.pojo.User;
import org.example.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //gain core config input stream
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //object SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //object SqlSessionFactory
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //object SqlSession
        //SqlSession sqlSession = build.openSession();
        //auto commit
        SqlSession sqlSession = build.openSession(true);
        //proxy object for user mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //implement method
        int result = mapper.insertUser();
        System.out.print("result "+result);
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById();
        System.out.println(userById);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.getUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin( "admin","123456");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"root","0123456",33,"female","fe@gamil.com");
        mapper.insertUser2(user);
    }
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
    }
}
