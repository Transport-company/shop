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
    public ResponseEntity<Cart> getById(Long cartId) {
        return ResponseEntity.ok(cartService.getById(cartId));
    }

    @Override
    public ResponseEntity<Cart> startShopping(CartLineRequest cartLineRequest) {
        cartService.startShopping(cartLineRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Cart> addInCart(Long cartId, CartLineRequest cartLineRequest) {
        cartService.addToCart(cartId, cartLineRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<String> deleteFromCart(Long cartId, Long itemId) {
        cartService.delete(cartId, itemId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<DeliveryResponse> formDelivery(Long cartId, DeliveryRequest deliveryRequest) {
        cartService.formDelivery(cartId, deliveryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}