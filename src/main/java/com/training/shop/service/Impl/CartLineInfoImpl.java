package com.training.shop.service.Impl;

import com.training.shop.service.CartLineInfo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartLineInfoImpl implements CartLineInfo {

    private ItemInfoImpl itemInfo;
    private BigDecimal quantity;

    @Override
    public void setItemInfo(ItemInfoImpl itemInfo) {
        this.itemInfo = itemInfo;
    }
}
