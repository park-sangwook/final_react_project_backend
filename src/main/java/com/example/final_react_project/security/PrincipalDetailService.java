package com.example.final_react_project.security;

import com.example.final_react_project.dao.LoginDAO;
import com.example.final_react_project.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final LoginDAO loginDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginDTO dto = loginDAO.selectById(username);
        return !Objects.isNull(dto)?new PrincipalDetails(dto):null;
    }
}
