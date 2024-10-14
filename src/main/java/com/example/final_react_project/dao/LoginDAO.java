package com.example.final_react_project.dao;

import com.example.final_react_project.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
    void insert(LoginDTO dto);
    LoginDTO selectById(String id);
}
