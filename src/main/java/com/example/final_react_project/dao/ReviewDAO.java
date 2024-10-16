package com.example.final_react_project.dao;

import com.example.final_react_project.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewDAO {
    void insert(ReviewDTO dto);
    void delete(int idx);
}
