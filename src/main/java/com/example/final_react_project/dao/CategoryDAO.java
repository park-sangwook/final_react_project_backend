package com.example.final_react_project.dao;

import com.example.final_react_project.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDAO {
    List<CategoryDTO> selectAll();
}
