package com.training.shop.controller.Impl;

import com.training.shop.controller.OrderInfoController;
import com.training.shop.dto.response.OrderInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderInfoControllerImpl implements OrderInfoController {

    @Override
    public ResponseEntity<OrderInfoResponse> getOrderInfo(Long id) {
        return null;
    }
}
