package com.example.final_react_project.config;

import com.example.final_react_project.dao.LoginDAO;
import com.example.final_react_project.security.JWTAuthenticationFilter;
import com.example.final_react_project.security.JWTAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SeurityConfig {
    private final AuthenticationManager authenticationManager;
    private final LoginDAO loginDAO;
    private final CorsFilter corsFilter;

    public SeurityConfig(@Lazy AuthenticationManager authenticationManager, LoginDAO loginDAO,@Lazy CorsFilter corsFilter) {
        this.authenticationManager = authenticationManager;
        this.loginDAO = loginDAO;
        this.corsFilter = corsFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{
        security.csrf(cs->cs.disable())
                .authorizeHttpRequests(ah->ah.requestMatchers("/user/**").authenticated()
                        .anyRequest().permitAll())
                .formLogin(login->login.disable())
                .sessionManagement(ses->ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(corsFilter)
                .addFilter(new JWTAuthenticationFilter(authenticationManager))
                .addFilter(new JWTAuthorizationFilter(authenticationManager,loginDAO));
        return security.build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
