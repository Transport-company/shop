package com.training.shop.service;

import com.training.shop.service.Impl.CartInfoImpl;
import com.training.shop.service.Impl.ItemInfoImpl;

import java.math.BigDecimal;

public interface CartInfo {

    /**
     * Method for setting item in shopping cart
     */
    void addItem(ItemInfoImpl itemInfo, BigDecimal quantity);

    /**
     * Method for search item in shopping cart by name
     */
    CartLineInfo findLineByName(String name);

    /**
     * Method for updating item in shopping cart
     */
    void updateItem(String name, BigDecimal amount);

    /**
     * Method for updating number of types of item in shopping cart
     */
    void updateQuantity(CartInfoImpl cartInfo);
}
