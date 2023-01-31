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

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

//        Map map = new HashMap();
        // map.put("status" , status);
//        map.put("companyName", companyName);
        // map.put("brandName" , brandName);



        BrandMapper brandMapper =createMapper(BrandMapper.class);

        //4. 执行方法

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        List<Brand> brands = brandMapper.selectByCondition(brand);
//        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
    }

    @Test
    public void selectByConditionSingle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        BrandMapper brandMapper =createMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        BrandMapper brandMapper = createMapper(BrandMapper.class);

        brandMapper.add(brand);
        System.out.println(brand);
    }
    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的拖拉机";
        int ordered = 200;
        int id = 22;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);

        BrandMapper brandMapper =createMapper(BrandMapper.class);

        //4. 执行方法


        int count = brandMapper.update(brand);
        System.out.println(count);


    }
    <T> T createMapper(Class<T> type) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(type);
    }
}
