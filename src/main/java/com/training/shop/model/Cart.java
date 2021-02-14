package com.training.shop.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity for the shopping cart
 */
@Entity
@Table(name = "cart")
@Data
public class Cart {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Array of positions in cart
     */
    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_lines", referencedColumnName = "id")
    private List<CartLine> cartLineList;

    /**
     * Price of all items in cart
     */
    @Column(name = "total_price")
    private Float totalPrice;

}
