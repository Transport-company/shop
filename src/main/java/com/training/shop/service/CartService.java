package com.training.shop.service;

import com.training.shop.dto.CartLineDto;
import com.training.shop.dto.DeliveryDto;
import com.training.shop.model.Cargo;
import com.training.shop.model.Cart;
import com.training.shop.model.Delivery;

import java.math.BigDecimal;

public interface CartService {

    /**
     * Method used for getting a cart by an id
     */
    Cart getById(Long id);

    /**
     * Method used to add product to cart. Require items id and amount
     */
    void addToCart(Long id,CartLineDto cartLineDto);

    /**
     * Delete position from cart. Firstly find required card by id, then delete position with items
     * with id is equals to translated itemId
     */
    void delete(Long id, Long itemId);

    /**
     * Method used to get total cost of items in cart
     */
    BigDecimal getTotalPrice(Long id);

    /**
     * Method used to get total weight of items in cart
     */
    Float getTotalWeight(Long id);

    /**
     * Method used to get total length of items in cart
     */
    Float getTotalLength(Long id);

    /**
     * Method used to get total width of items in cart
     */
    Float getTotalWidth(Long id);

    /**
     * Method used to get total height of items in cart
     */
    Float getTotalHeight(Long id);

    /**
     * Method used to simplify storage of cargo information
     */
    Cargo formCargo(Long id);

    /**
     * Method used in case of Cargo updating
     */
    void updateCargo(Long id);

    /**
     * Pass an information from cart to delivery. Used as confirmation of purchase and  source of new Delivery
     */
    Delivery formDelivery(Long id, DeliveryDto deliveryDto);
}
