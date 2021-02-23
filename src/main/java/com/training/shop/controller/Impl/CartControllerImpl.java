package com.training.shop.controller.Impl;

import com.training.shop.controller.CartController;
import com.training.shop.dto.reqest.CartLineRequest;
import com.training.shop.dto.reqest.DeliveryRequest;
import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.model.Cart;
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
    public ResponseEntity<Cart> addInCart(Long id, CartLineRequest cartLineRequest) {
        cartService.addToCart(id, cartLineRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<String> deleteFromCart(Long cartId, Long itemId) {
        cartService.delete(cartId, itemId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<DeliveryResponse> formDelivery(Long id, DeliveryRequest deliveryRequest) {
        cartService.formDelivery(id, deliveryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}