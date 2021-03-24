package com.training.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Entity for the shopping cart
 */
@Entity
@Table(name = "cart")
@Data
@Builder
@ToString(exclude = "cartLine")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Set of positions in cart
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartLine> cartLine;

    /**
     * Price of all items in cart
     */
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;


    /**
     * Weight of all items in cart
     */
    @Column(name = "total_weight", nullable = false)
    private Float totalWeight;

    /**
     * Length of all items in cart
     */
    @Column(name = "total_length", nullable = false)
    private Float totalLength;

    /**
     * Width of all items in cart
     */
    @Column(name = "total_width", nullable = false)
    private Float totalWidth;

    /**
     * Height of all items in cart
     */
    @Column(name = "total_height", nullable = false)
    private Float totalHeight;

}