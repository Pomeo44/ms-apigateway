package com.flixbus.apigateway.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * BusCost.
 *
 * @author Aleksandr_Antipin
 */
@Entity
@Data
@Accessors(chain = true)
public class UserRole {

    @Id
    private Long id;

    @Column
    private String name;
}