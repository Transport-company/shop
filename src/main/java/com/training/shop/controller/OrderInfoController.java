package com.training.shop.controller;

import com.training.shop.Urls;
import com.training.shop.dto.response.OrderInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Order Info", description = "Order info related interaction endpoints")
public interface OrderInfoController {

    @Operation(summary = "Get information about order", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderInfoController.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(Urls.OrderInfo.Id.FULL)
    ResponseEntity<OrderInfoResponse> getOrderInfo(@Parameter(name = "id",
            description = "Order unique identifier",
            required = true) @PathVariable("id") Long id);
}