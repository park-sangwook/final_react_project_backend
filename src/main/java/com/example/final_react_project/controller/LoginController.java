package com.example.final_react_project.controller;

import com.example.final_react_project.dto.LoginDTO;
import com.example.final_react_project.security.PrincipalDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public LoginDTO user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        LoginDTO dto = principalDetails.getDto();
        return new LoginDTO(dto.getId(),null,dto.getRole(),dto.getProvider());
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
