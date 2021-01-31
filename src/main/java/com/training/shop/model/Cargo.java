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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "client")
    private String client;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;
}
