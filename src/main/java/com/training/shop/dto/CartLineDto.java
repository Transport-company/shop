package com.training.shop.dto;

import com.training.shop.model.Item;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartLineDto {

    /**
     * Link to an item identifier
     */
    private Item item;

    /**
     * Amount of items
     */
    private BigDecimal amount;
}
