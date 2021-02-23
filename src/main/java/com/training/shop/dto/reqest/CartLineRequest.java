package com.training.shop.dto.reqest;

import com.training.shop.model.Product;
import lombok.Data;

@Data
public class CartLineRequest {

    /**
     * Link to an item identifier
     */
    private Product product;

    /**
     * Amount of items
     */
    private Integer amount;
}
