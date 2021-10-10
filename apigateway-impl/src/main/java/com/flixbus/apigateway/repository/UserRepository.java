/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package com.flixbus.apigateway.repository;

import com.flixbus.apigateway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository.
 *
 * @author Aleksandr_Antipin
 */
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByLogin(String login);
}