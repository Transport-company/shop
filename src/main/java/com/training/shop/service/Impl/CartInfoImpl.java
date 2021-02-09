package com.training.shop.service.Impl;


import com.training.shop.service.CartInfo;
import com.training.shop.service.CartLineInfo;
import com.training.shop.service.ItemInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CartInfoImpl implements CartInfo {

    private final List<CartLineInfoImpl> cartLines = new ArrayList<>();

    public CartInfoImpl() {

    }

    @Override
    public void addItem(ItemInfoImpl itemInfo, BigDecimal quantity) {
        CartLineInfoImpl line = this.findLineByName(itemInfo.getName());

        if (line == null){
            line = new CartLineInfoImpl();
            line.setQuantity(BigDecimal.ZERO);
            line.setItemInfo(itemInfo);
            this.cartLines.add(line);
        }
        BigDecimal newQuantity = line.getQuantity();
        newQuantity = quantity.plus();
        if (newQuantity.compareTo(BigDecimal.ZERO) <= 0 ){
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }

    @Override
    public CartLineInfoImpl findLineByName(String name) {
        for (CartLineInfoImpl line: this.cartLines){
            if (line.getItemInfo().getName().equals(name)){
                return line;
            }
        }
        return null;
    }

    @Override
    public void updateItem(String name, BigDecimal quantity) {
        CartLineInfoImpl line = this.findLineByName(name);

        if (line != null) {
            if (quantity.compareTo(BigDecimal.ZERO) <= 0 ){
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }

    @Override
    public void updateQuantity(CartInfoImpl cartInfo) {
        if(cartInfo != null){
            List<CartLineInfoImpl> lines = cartInfo.getCartLines();
            for (CartLineInfoImpl line : lines){
                this.updateItem(line.getItemInfo().getName(), line.getQuantity());
            }
        }
    }
}
