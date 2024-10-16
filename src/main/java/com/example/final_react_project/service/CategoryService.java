package com.example.final_react_project.service;

import com.example.final_react_project.dao.CategoryDAO;
import com.example.final_react_project.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDAO categoryDAO;

    public List<CategoryDTO> selectAll(){
        return categoryDAO.selectAll();
    }
}
