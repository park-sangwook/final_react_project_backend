package com.example.final_react_project.dao;

import com.example.final_react_project.dto.OrderedDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderedDAO {
    void insert(OrderedDTO dto);
    void delete(int idx);
}
