package com.example.demo.mappers;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> selectAllUser();
}
