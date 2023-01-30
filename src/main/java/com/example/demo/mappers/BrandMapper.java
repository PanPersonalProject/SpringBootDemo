package com.example.demo.mappers;

import com.example.demo.bean.Brand;

import java.io.IOException;
import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll() throws IOException;

    Brand selectById(int id);

}
