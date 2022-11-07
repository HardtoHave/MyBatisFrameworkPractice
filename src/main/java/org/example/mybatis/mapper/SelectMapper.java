package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.example.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User getUserById(@Param("id") Integer id);
    List<User> getAllUser();
    Integer getCount();
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
