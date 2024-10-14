package com.example.final_react_project.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.final_react_project.dao.LoginDAO;
import com.example.final_react_project.dto.LoginDTO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.Objects;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private final LoginDAO loginDAO;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, LoginDAO loginDAO) {
        super(authenticationManager);
        this.loginDAO = loginDAO;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if(Objects.isNull(header) || !header.startsWith("Bearer ")){
            chain.doFilter(request,response);
            return ;
        }

        String token = header.replace("Bearer ","");
        String username = JWT.require(Algorithm.HMAC512("cos")).build().verify(token).getClaim("id").asString();
        LoginDTO dto = loginDAO.selectById(username);
        if(!Objects.isNull(dto)){
            PrincipalDetails principalDetails = new PrincipalDetails(dto);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request,response);
        }
    }
}
