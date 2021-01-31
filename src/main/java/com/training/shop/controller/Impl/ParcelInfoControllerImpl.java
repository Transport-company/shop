package com.training.shop.controller.Impl;

import com.training.shop.controller.ParcelInfoController;
import com.training.shop.dto.response.ParcelInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelInfoControllerImpl implements ParcelInfoController {

    @Override
    public ResponseEntity<ParcelInfoResponse> getParcelInfo(Long id) {
        return null;
    }
}
