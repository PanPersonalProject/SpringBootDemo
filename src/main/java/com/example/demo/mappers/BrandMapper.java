package com.example.demo.mappers;

import com.example.demo.bean.Brand;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll() throws IOException;

    Brand selectById(int id);

    /**
     * 传参方式
     * * 参数接收
     * 1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     * 2. 对象参数:对象的属性名称要和参数占位符名称一致
     * 3. map集合参数
     */

//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);
//    List<Brand> selectByCondition(Map map);


    //单条件查询
    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

}
