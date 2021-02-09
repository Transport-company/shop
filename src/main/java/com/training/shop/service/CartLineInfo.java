package com.training.shop.service;

import com.training.shop.service.Impl.ItemInfoImpl;

import java.math.BigDecimal;

public interface CartLineInfo {
    /**
     * Method for setting amount of items of different types
     */
    void setQuantity(BigDecimal quantity);
    /**
     * Methods for setting information about item
     */
    void setItemInfo(ItemInfoImpl itemInfo);
}
