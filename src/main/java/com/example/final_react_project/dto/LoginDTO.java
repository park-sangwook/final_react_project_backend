package com.example.final_react_project.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
    private int idx;
    private String id;
    private String password;
    private String role;
    private String provider;

    @Builder
    public LoginDTO(String id, String password, String role, String provider) {
        this.id = id;
        this.password = password;
        this.role = role;
        this.provider = provider;
    }
}
