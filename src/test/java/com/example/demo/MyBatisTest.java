package com.example.demo;

import com.example.demo.bean.Brand;
import com.example.demo.mappers.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {


    @Test
    public void selectAll() throws IOException {
        BrandMapper brandMapper = createMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
    }

    @Test
    public void selectById() throws IOException {
        BrandMapper brandMapper = createMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(3);
        System.out.println(brand);
    }

    <T> T createMapper(Class<T> type) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(type);
    }
}
