package com.example.final_react_project.service;

import com.example.final_react_project.dao.CompanyDAO;
import com.example.final_react_project.dao.MenuDAO;
import com.example.final_react_project.dto.CompanyDTO;
import com.example.final_react_project.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyDAO companyDAO;

    private final MenuDAO menuDAO;
    public List<CompanyDTO> selectAllByIdx(int idx){
        return companyDAO.selectAllByIdx(idx);
    }

    public List<CompanyDTO> selectAll(){
        return companyDAO.selectAll();
    }

    public CompanyDTO selectByIdx(int idx){
        List<MenuDTO> dto = menuDAO.selectAll(idx);
        CompanyDTO cd = companyDAO.selectByIdx(idx);
        cd.setMenuList(dto);
        return cd;
    }
}
