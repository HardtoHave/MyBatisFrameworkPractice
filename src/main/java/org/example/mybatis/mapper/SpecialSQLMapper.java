package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.User;

import java.util.List;

public interface SpecialSQLMapper {
    List<User> getUserByLike(@Param("undef") String undef);
    void deleteMoreUser(@Param("ids") String ids);
    List<User> getUserList(@Param("tableName")String tableName);
    void insertUser(User user);
}
