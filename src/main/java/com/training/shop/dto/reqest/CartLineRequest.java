package com.training.shop.dto.reqest;

import lombok.Data;

@Data
public class CartLineRequest {

    /**
     * Link to an item identifier
     */
    private final Long productId;

    /**
     * Amount of items
     */
    private final Integer amount;
}
