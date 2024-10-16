package com.example.final_react_project.service;

import com.example.final_react_project.dao.MenuDAO;
import com.example.final_react_project.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuDAO menuDAO;

    public List<MenuDTO> selectAll(int idx){
        return menuDAO.selectAll(idx);
    }

    public MenuDTO selectByIdx(int idx){
        return menuDAO.selectByIdx(idx);
    }

}
