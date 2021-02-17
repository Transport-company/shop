package com.training.shop.dto;

import com.training.shop.model.Item;
import lombok.Data;


@Data
public class CartLineDto {

    /**
     * Link to an item identifier
     */
    private Item item;

    /**
     * Amount of items
     */
    private Integer amount;
}
