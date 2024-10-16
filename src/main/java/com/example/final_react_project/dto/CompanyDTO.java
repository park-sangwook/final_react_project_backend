package com.example.final_react_project.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {
    private int idx;
    private String name;
    private String image;
    private double rate;
    private int category_idx;
    private List<MenuDTO> menuList;
}
