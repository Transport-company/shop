package com.training.shop.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Model for shop
 */
@Entity
@Table(name = "shop")
@Data
public class Shop {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Shop name
     */
    @Column(name = "name")
    private String name;

    /**
     * Location of shop
     */
    @Column(name = "city")
    private String city;

    /**
     * Shop address
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Address.class)
    @JoinColumn(name = "sending_address_id")
    private Address sendingAddress;
}
