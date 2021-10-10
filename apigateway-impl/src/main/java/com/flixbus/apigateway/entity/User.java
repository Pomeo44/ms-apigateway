package com.flixbus.apigateway.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * BusCost.
 *
 * @author Aleksandr_Antipin
 */
@Entity
@Data
@Accessors(chain = true)
public class User {

    @Id
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToOne
    private UserRole userRole;
}