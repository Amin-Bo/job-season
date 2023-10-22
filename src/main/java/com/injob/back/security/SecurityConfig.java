package com.injob.back.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
@Slf4j
class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;

    private final ObjectMapper mapper;
    private static final String[] SWAGGER_WHITELIST = {
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


            http.
                    authorizeHttpRequests()
                    .requestMatchers(SWAGGER_WHITELIST).permitAll()
                    .anyRequest()
                    .permitAll();
            http.oauth2ResourceServer()
                    .jwt()
                    .jwtAuthenticationConverter(jwtAuthConverter);
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.cors();
            return http.build();


    }


}