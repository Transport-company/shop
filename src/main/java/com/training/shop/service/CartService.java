package com.training.shop.service;

import com.training.shop.dto.CartLineDto;
import com.training.shop.model.Cart;
import com.training.shop.model.Delivery;

public interface CartService {

    /**
     * Method used for getting a cart by an id
     */
    Cart getById(Long id);

    /**
     * Method used to add product to cart. Require items id and amount
     */
    void addToCart(Long id,CartLineDto cartLineDTO);

    /**
     * Delete position from cart. Firstly find required card by id, then delete position with items
     * with id is equals to translated itemId
     */
    void delete(Long id, Long itemId);

    /**
     * Pass an information from cart to delivery. Used as confirmation of purchase and  source of new Delivery
     */
    Delivery formDelivery(Long id, Delivery delivery); // Method in progress
}
