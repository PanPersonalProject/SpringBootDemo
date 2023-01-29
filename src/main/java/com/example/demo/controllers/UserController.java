package com.example.demo.controllers;

import com.example.demo.bean.User;
import com.example.demo.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/getUserList")  //http://localhost:8080/getUserList
    public List<User> getUserList() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //获得SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        List<User> users = sqlSession.selectList("User.selectAllUser");  不推荐的方式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //mapper代理，动态代理方式实例化interface
        List<User> users = userMapper.selectAllUser();
        sqlSession.close();
        return users;
    }

}
