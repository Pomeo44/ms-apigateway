/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2021 VTB Group. All rights reserved.
 */

package com.flixbus.apigateway.repository;

import com.flixbus.apigateway.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleRepository.
 *
 * @author Aleksandr_Antipin
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);
}