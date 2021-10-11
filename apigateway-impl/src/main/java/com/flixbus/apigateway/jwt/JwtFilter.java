/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package com.flixbus.apigateway.jwt;

import static org.springframework.util.StringUtils.hasText;

import com.flixbus.apigateway.service.CustomUserDetails;
import com.flixbus.apigateway.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * JwtFilter.
 *
 * @author Aleksandr_Antipin
 */
@Component
@Slf4j
public class JwtFilter implements WebFilter {

    private final JwtProvider jwtProvider;
    private CustomUserDetailsService customUserDetailsService;

    public JwtFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Autowired
    public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        log.info("do filter...");
        String token = getTokenFromRequest(serverWebExchange.getRequest());
        if (token != null && jwtProvider.validateToken(token)) {
            String userLogin = jwtProvider.getLoginFromToken(token);
            CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
            return webFilterChain
                    .filter(serverWebExchange)
                    .subscriberContext(ReactiveSecurityContextHolder.withAuthentication(authentication));
        }

        return webFilterChain.filter(serverWebExchange);
    }

    private String getTokenFromRequest(ServerHttpRequest request) {
        return Optional.ofNullable(request.getHeaders().get(HttpHeaders.AUTHORIZATION))
                .map(list -> list.get(0))
                .map(bearer -> hasText(bearer) && bearer.startsWith("Bearer ") ? bearer.substring(7) : null).orElse(null);
    }


}