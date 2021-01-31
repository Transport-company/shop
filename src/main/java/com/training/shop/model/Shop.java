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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;
}
