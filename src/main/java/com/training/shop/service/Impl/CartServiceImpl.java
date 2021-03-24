package com.training.shop.service.Impl;

import com.training.shop.dto.reqest.CartLineRequest;
import com.training.shop.dto.reqest.DeliveryRequest;
import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.mapper.DeliveryMapper;
import com.training.shop.model.Cargo;
import com.training.shop.model.Cart;
import com.training.shop.model.CartLine;
import com.training.shop.repository.CargoRepository;
import com.training.shop.repository.CartRepository;
import com.training.shop.repository.DeliveryRepository;
import com.training.shop.repository.ProductRepository;
import com.training.shop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CargoRepository cargoRepository;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final ProductRepository productRepository;

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void startShopping(CartLineRequest cartLineRequest) {
        Cart cart = new Cart();
        CartLine cartLine = new CartLine();
        cartLine.setProduct(productRepository.getOne(cartLineRequest.getProductId()));
        cartLine.setAmount(cartLineRequest.getAmount());
        Set<CartLine> cartLines = new HashSet<>();
        cart.setTotalWeight(productRepository.getOne(cartLineRequest.getProductId()).getWeight()
                * cartLineRequest.getAmount());
        cart.setTotalHeight(productRepository.getOne(cartLineRequest.getProductId()).getHeight()
                * cartLineRequest.getAmount());
        cart.setTotalLength(productRepository.getOne(cartLineRequest.getProductId()).getLength()
                * cartLineRequest.getAmount());
        cart.setTotalWidth(productRepository.getOne(cartLineRequest.getProductId()).getWidth()
                * cartLineRequest.getAmount());
        cart.setTotalPrice(productRepository.getOne(cartLineRequest.getProductId()).getPrice().multiply(BigDecimal
                .valueOf(cartLineRequest.getAmount())));
        cartLines.add(cartLine);
        cart.setCartLine(cartLines);
        cartRepository.save(cart);
    }

    @Override
    public void addToCart(Long id, CartLineRequest cartLineRequest) {
        Cart cart = cartRepository.getOne(id);
        CartLine cartLine = new CartLine();
        cartLine.setProduct(productRepository.getOne(cartLineRequest.getProductId()));
        cartLine.setAmount(cartLineRequest.getAmount());
        Set<CartLine> cartLines = cart.getCartLine();
        cartLines.add(cartLine);
        cart.setCartLine(cartLines);
        cart.setTotalWeight(cart.getTotalWeight() + productRepository.getOne(cartLineRequest.getProductId())
                .getWeight() * cartLineRequest.getAmount());
        cart.setTotalHeight(cart.getTotalHeight() + productRepository.getOne(cartLineRequest.getProductId())
                .getHeight() * cartLineRequest.getAmount());
        cart.setTotalLength(cart.getTotalLength() + productRepository.getOne(cartLineRequest.getProductId())
                .getLength() * cartLineRequest.getAmount());
        cart.setTotalWidth(cart.getTotalWidth() + productRepository.getOne(cartLineRequest.getProductId())
                .getWidth() * cartLineRequest.getAmount());
        cart.setTotalPrice(productRepository.getOne(cartLineRequest.getProductId()).getPrice()
                .multiply(BigDecimal.valueOf(cartLineRequest.getAmount())).add(cart.getTotalPrice()));
        cartRepository.save(cart);
    }

    @Override
    public void delete(Long id, Long itemId) {
        Cart cart = cartRepository.getOne(id);
        Set<CartLine> cartLines = cart.getCartLine();
        for (CartLine cartLine : cartLines) {
            if (cartLine.getProduct().getId().equals(itemId)) {
                cartLine.setProduct(null);
                cartLine.setAmount(null);
                cartLine.setId(null);
            }
        }
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = cartRepository.getOne(id);
        Set<CartLine> cartLines = cart.getCartLine();
        return cartLines.stream().map(cartLine -> cartLine.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(cartLine.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Float getTotalWeight(Long id) {
        Cart cart = cartRepository.getOne(id);
        Set<CartLine> cartLines = cart.getCartLine();
        return cartLines.stream().map(cartLine -> cartLine.getProduct().getWeight() * cartLine.getAmount()
                .floatValue())
                .reduce(1.0f, Float::sum);
    }

    @Override
    public Float getTotalLength(Long id) {
        Cart cart = cartRepository.getOne(id);
        Set<CartLine> cartLines = cart.getCartLine();
        return cartLines.stream().map(cartLine -> cartLine.getProduct().getLength() * cartLine.getAmount()
                .floatValue())
                .reduce(1.0f, Float::sum);
    }

    @Override
    public Float getTotalWidth(Long id) {
        Cart cart = cartRepository.getOne(id);
        Set<CartLine> cartLines = cart.getCartLine();
        return cartLines.stream().map(cartLine -> cartLine.getProduct().getWeight() * cartLine.getAmount()
                .floatValue())
                .reduce(1.0f, Float::sum);
    }

    @Override
    public Float getTotalHeight(Long id) {
        Cart cart = cartRepository.getOne(id);
        Set<CartLine> cartLines = cart.getCartLine();
        return cartLines.stream().map(cartLine -> cartLine.getProduct().getHeight() * cartLine.getAmount()
                .floatValue())
                .reduce(1.0f, Float::sum);
    }

    @Override
    public Cargo formCargo(Long id) {
        return Cargo.builder()
                .weight(getTotalWeight(id))
                .length(getTotalLength(id))
                .width(getTotalWidth(id))
                .height(getTotalHeight(id))
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }

    @Override
    public void updateCargo(Long id) {
        cargoRepository.getOne(id).setUpdated(LocalDateTime.now());
    }

    @Override
    public DeliveryResponse formDelivery(Long id, DeliveryRequest deliveryRequest) {
        DeliveryResponse delivery = DeliveryResponse.builder()
                .enabledNotifications(deliveryRequest.getEnabledNotifications())
                .paid(deliveryRequest.getPaid())
                .sendingAddress(deliveryRequest.getShop().getSendingAddress())
                .shippingAddress(deliveryRequest.getShippingAddress())
                .client(deliveryRequest.getClient())
                .cargo(formCargo(id))
                .sum(getTotalPrice(id))
                .status(deliveryRequest.getStatus())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
        deliveryRepository.save(deliveryMapper.toDeliveryResponse(delivery));
        return delivery;
    }
}