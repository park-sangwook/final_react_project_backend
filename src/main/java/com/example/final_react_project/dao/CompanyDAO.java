package com.example.final_react_project.dao;

import com.example.final_react_project.dto.CategoryDTO;
import com.example.final_react_project.dto.CompanyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyDAO {
    List<CompanyDTO> selectAllByIdx(int idx);
    List<CompanyDTO> selectAll();
    CompanyDTO selectByIdx(int idx);
}
