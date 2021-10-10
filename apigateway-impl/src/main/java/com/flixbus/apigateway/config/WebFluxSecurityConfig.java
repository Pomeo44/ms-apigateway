/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package com.flixbus.apigateway.config;

import com.flixbus.apigateway.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * MyWebFluxSecurityConfiguration.
 *
 * @author Aleksandr_Antipin
 */
@Configuration(proxyBeanMethods = false)
public class WebFluxSecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable()
                .authorizeExchange(spec -> {
                        spec.pathMatchers("/auth").permitAll();
                        spec.pathMatchers("/**").authenticated();})
                .addFilterBefore(jwtFilter, SecurityWebFiltersOrder.HTTP_BASIC);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}