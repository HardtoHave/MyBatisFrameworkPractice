package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser();
    void updateUser();
    void deleteUser();
    User getUserById();
    List<User> getAllUser();
    User getUserByUsername(String username);
    User checkLogin(String username, String password);
    User checkLoginByMap(Map<String,Object> map);
    void insertUser2(User user);
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
