package com.training.shop.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Model for cargo
 */

@Entity
@Table(name = "cargo")
@Data
public class Cargo {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cargo code for inside use
     */
    @Column(name = "number")
    private Long number;

    /**
     * Client name
     */
    @Column(name = "client")
    private String client;

    /**
     * Client city
     */
    @Column(name = "city")
    private String city;

    /**
     * Client address
     */
    @Column(name = "address")
    private String address;

    /**
     * Sender shop info
     */
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;
}
