package com.example.final_react_project.service;

import com.example.final_react_project.dao.LoginDAO;
import com.example.final_react_project.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginDAO loginDAO;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public void insert(LoginDTO dto){
        String rawPassword = dto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        dto.setPassword(encPassword);
        dto.setRole("USER");
        loginDAO.insert(dto);
    }

    public LoginDTO selectById(String id){
        LoginDTO dto = loginDAO.selectById(id);
        return Objects.isNull(dto)?null:dto;
    }
}
