package com.training.shop.controller.client;

import com.training.shop.dto.response.OrderInfoResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "core",
        url = "${core.trackingAPI.url}",
        fallback = OrderInfoClientFallback.class)
public interface OrderInfoClient {

    String ID_PATH_VARIABLE = "/{id}";

    @GetMapping(ID_PATH_VARIABLE)
    ResponseEntity<OrderInfoResponse> getOrderInfo(@Parameter(name = "id",
            description = "Order unique identifier",
            required = true) @PathVariable("id") Long id);

}
