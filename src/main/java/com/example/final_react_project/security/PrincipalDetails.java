package com.example.final_react_project.security;

import com.example.final_react_project.dto.LoginDTO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class PrincipalDetails implements UserDetails {
    private LoginDTO dto;

    public PrincipalDetails(LoginDTO dto) {
        this.dto = dto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> ga = new ArrayList<>();
        ga.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+dto.getRole();
            }
        });
        return ga;
    }

    @Override
    public String getPassword() {
        return dto.getPassword();
    }

    @Override
    public String getUsername() {
        return dto.getId();
    }
}
