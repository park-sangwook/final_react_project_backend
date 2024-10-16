package com.example.final_react_project.dao;

import com.example.final_react_project.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDAO {
    MenuDTO selectByIdx(int idx);
    List<MenuDTO> selectAll(int idx);
}
