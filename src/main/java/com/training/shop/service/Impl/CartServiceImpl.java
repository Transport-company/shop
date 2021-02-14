package com.training.shop.service.Impl;

import com.training.shop.dto.CartLineDto;
import com.training.shop.model.Cart;
import com.training.shop.model.CartLine;
import com.training.shop.model.Delivery;
import com.training.shop.repository.CartRepository;
import com.training.shop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void addToCart(Long id, CartLineDto cartLineDTO) {

        Cart cart = cartRepository.getOne(id);
        CartLine cartLine = new CartLine();
        List<CartLine> cartLineList = new ArrayList<>();
        cartLine.setId(cartLineDTO.getItem().getId());
        cartLine.setAmount(cartLineDTO.getAmount());
        cartLineList.add(cartLine);
        cart.setCartLineList(cartLineList);
        cartRepository.save(cart);

    }

    @Override
    public void delete(Long id, Long itemId) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        for (CartLine cartLine : cartLineList){
            if(cartLine.getItem().getId().equals(itemId)){
                cartLine.setItem(null);
                cartLine.setAmount(null);
                cartLine.setId(null);
            }
        }
    }


    @Override
    public Delivery formDelivery(Long id, Delivery delivery) {
        return null;
    }
}
