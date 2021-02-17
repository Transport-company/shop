package com.training.shop.service.Impl;

import com.training.shop.dto.CartLineDto;
import com.training.shop.dto.DeliveryDto;
import com.training.shop.model.Cargo;
import com.training.shop.model.Cart;
import com.training.shop.model.CartLine;
import com.training.shop.model.Delivery;
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
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = cartRepository.getOne(id);
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<CartLine> cartLineList = cart.getCartLineList();

        for (CartLine cartLine : cartLineList){
            BigDecimal price = cartLine.getItem().getPrice().multiply(BigDecimal.valueOf(cartLine.getAmount()));
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
            totalWeight = totalWeight + cartLine.getItem().getWeight() * cartLine.getAmount();
        }
        return totalWeight;
    }

    @Override
    public Float getTotalLength(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalLength = 0;
        for (CartLine cartLine : cartLineList){
            totalLength = totalLength + cartLine.getItem().getLength() * cartLine.getAmount();
        }
        return totalLength;
    }

    @Override
    public Float getTotalWidth(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalWidth = 0;
        for (CartLine cartLine : cartLineList){
            totalWidth = totalWidth + cartLine.getItem().getWidth() * cartLine.getAmount();
        }
        return totalWidth;
    }

    @Override
    public Float getTotalHeight(Long id) {
        Cart cart = cartRepository.getOne(id);
        List<CartLine> cartLineList = cart.getCartLineList();
        float totalHeight = 0;
        for (CartLine cartLine : cartLineList){
            totalHeight = totalHeight + cartLine.getItem().getHeight() * cartLine.getAmount();
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
    public Delivery formDelivery(Long id, DeliveryDto deliveryDto) {
        Delivery delivery = new Delivery();
        delivery.setEnabledNotifications(deliveryDto.getEnabledNotifications());
        delivery.setShippingAddress(deliveryDto.getShippingAddress());
        delivery.setSendingAddress(deliveryDto.getShop().getSendingAddress());
        delivery.setCargo(formCargo(id));
        delivery.setSum(getTotalPrice(id));
        delivery.setClient(deliveryDto.getClient());
        delivery.setIsPaid(deliveryDto.getIsPaid());
        delivery.setStatus(deliveryDto.getStatus());
        delivery.setCreated(LocalDateTime.now());
        delivery.setUpdated(LocalDateTime.now());
        deliveryRepository.save(delivery);
        return delivery;
    }
}
