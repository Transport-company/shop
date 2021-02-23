package com.training.shop.service.Impl;

import com.training.shop.dto.reqest.CartLineRequest;
import com.training.shop.dto.reqest.DeliveryRequest;
import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.model.Cargo;
import com.training.shop.model.Cart;
import com.training.shop.model.CartLine;
import com.training.shop.repository.CargoRepository;
import com.training.shop.repository.CartRepository;
import com.training.shop.repository.DeliveryRepository;
import com.training.shop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CargoRepository cargoRepository;
    private final DeliveryRepository deliveryRepository;

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void addToCart(Long id, CartLineRequest cartLineRequest) {

        Cart cart = cartRepository.getOne(id);
        CartLine cartLine = new CartLine();
        List<CartLine> cartLineList = new ArrayList<>();
        cartLine.setId(cartLineRequest.getProduct().getId());
        cartLine.setAmount(cartLineRequest.getAmount());
        cartLineList.add(cartLine);
        cart.setCartLineList(cartLineList);
        cartRepository.save(cart);
    }

    @Override
    public void delete(Long id, Long itemId) {

        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        for (CartLine cartLine : cartLineList){
            if(cartLine.getProduct().getId().equals(itemId)){
                cartLine.setProduct(null);
                cartLine.setAmount(null);
                cartLine.setId(null);
            }
        }
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = cartRepository.getOne(id);
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<CartLine> cartLineList = cart.getCartLineList();

        for (CartLine cartLine : cartLineList){
            BigDecimal price = cartLine.getProduct().getPrice().multiply(BigDecimal.valueOf(cartLine.getAmount()));
            totalPrice = totalPrice.add(price);
        }

        return totalPrice;
    }

    @Override
    public Float getTotalWeight(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalWeight = 0;
        for (CartLine cartLine : cartLineList){
            totalWeight = totalWeight + cartLine.getProduct().getWeight() * cartLine.getAmount();
        }
        return totalWeight;
    }

    @Override
    public Float getTotalLength(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalLength = 0;
        for (CartLine cartLine : cartLineList){
            totalLength = totalLength + cartLine.getProduct().getLength() * cartLine.getAmount();
        }
        return totalLength;
    }

    @Override
    public Float getTotalWidth(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalWidth = 0;
        for (CartLine cartLine : cartLineList){
            totalWidth = totalWidth + cartLine.getProduct().getWidth() * cartLine.getAmount();
        }
        return totalWidth;
    }

    @Override
    public Float getTotalHeight(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalHeight = 0;
        for (CartLine cartLine : cartLineList){
            totalHeight = totalHeight + cartLine.getProduct().getHeight() * cartLine.getAmount();
        }
        return totalHeight;
    }

    @Override
    public Cargo formCargo(Long id) {
        Cargo cargo = new Cargo();
        cargo.setWeight(getTotalWeight(id));
        cargo.setLength(getTotalLength(id));
        cargo.setWidth(getTotalWidth(id));
        cargo.setHeight(getTotalHeight(id));
        cargo.setCreated(LocalDateTime.now());
        cargo.setUpdated(LocalDateTime.now());
        return cargo;
    }

    @Override
    public void updateCargo(Long id) {
        cargoRepository.getOne(id).setUpdated(LocalDateTime.now());
    }

    @Override
    public DeliveryResponse formDelivery(Long id, DeliveryRequest deliveryRequest) {
        DeliveryResponse delivery = new DeliveryResponse();
        delivery.setEnabledNotifications(deliveryRequest.getEnabledNotifications());
        delivery.setShippingAddress(deliveryRequest.getShippingAddress());
        delivery.setSendingAddress(deliveryRequest.getShop().getSendingAddress());
        delivery.setCargo(formCargo(id));
        delivery.setSum(getTotalPrice(id));
        delivery.setClient(deliveryRequest.getClient());
        delivery.setIsPaid(deliveryRequest.getIsPaid());
        delivery.setStatus(deliveryRequest.getStatus());
        delivery.setCreated(LocalDateTime.now());
        delivery.setUpdated(LocalDateTime.now());
        deliveryRepository.save(delivery);
        return delivery;
    }

}