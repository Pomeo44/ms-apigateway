package com.flixbus.apigateway.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * BusCost.
 *
 * @author Aleksandr_Antipin
 */
@Entity
@Data
@Accessors(chain = true)
@Table(name = "users")
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