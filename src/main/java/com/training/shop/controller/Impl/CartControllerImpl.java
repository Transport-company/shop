package com.training.shop.controller.Impl;

import com.training.shop.controller.CartController;
import com.training.shop.dto.CartLineDto;
import com.training.shop.dto.DeliveryDto;
import com.training.shop.dto.request.DeliveryRequest;
import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.model.Cart;
import com.training.shop.model.Delivery;
import com.training.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartControllerImpl implements CartController {

    private final CartService cartService;

    @Override
    public ResponseEntity<Cart> getById(Long id) {
        return ResponseEntity.ok(cartService.getById(id));
    }

    @Override
    public ResponseEntity<Cart> addInCart(Long id, CartLineDto cartLineDTO) {
        cartService.addToCart(id, cartLineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<String> deleteFromCart(Long cartId, Long itemId) {
        cartService.delete(cartId, itemId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Delivery> formDelivery(Long id, DeliveryDto deliveryDto) {
        cartService.formDelivery(id, deliveryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
