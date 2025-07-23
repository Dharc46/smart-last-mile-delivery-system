package com.example.smartlastmiledeliverysystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Tắt CSRF để dễ test với Postman
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/**").permitAll() // Tạm thời cho phép tất cả request đến /api/v1/**
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());
        return http.build();
    }
}