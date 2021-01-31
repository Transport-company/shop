package com.training.shop.controller;

import com.training.shop.Urls;
import com.training.shop.dto.response.ParcelInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ParcelInfoController {

    @GetMapping(Urls.ParcelInfo.Id.FULL)
    ResponseEntity<ParcelInfoResponse> getParcelInfo(@PathVariable("id") Long id);
}
