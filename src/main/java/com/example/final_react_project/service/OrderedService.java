package com.example.final_react_project.service;

import com.example.final_react_project.dao.OrderedDAO;
import com.example.final_react_project.dto.OrderedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderedService {
    private final OrderedDAO orderedDAO;

    @Transactional
    public void insert(OrderedDTO dto){
        orderedDAO.insert(dto);
    }
}
