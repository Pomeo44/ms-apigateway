/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package com.flixbus.apigateway.controller;

import com.flixbus.apigateway.entity.User;
import com.flixbus.apigateway.jwt.JwtProvider;
import com.flixbus.apigateway.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController.
 *
 * @author Aleksandr_Antipin
 */
@RestController
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private JwtProvider jwtProvider;

    @PostMapping("/auth")
    public String auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        return jwtProvider.generateToken(user);
    }

    @Data
    public static class AuthRequest {
        private String login;
        private String password;
    }
}