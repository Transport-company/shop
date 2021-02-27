package com.training.shop.controller.client;

import com.training.shop.dto.response.OrderInfoResponse;
import org.springframework.http.ResponseEntity;

public class OrderInfoClientFallback implements OrderInfoClient{

    @Override
    public ResponseEntity<OrderInfoResponse> getOrderInfo(Long id) {
        return null;
    }
}
