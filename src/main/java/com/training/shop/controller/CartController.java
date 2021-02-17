package com.training.shop.controller;

import com.training.shop.Urls;
import com.training.shop.dto.CartLineDto;
import com.training.shop.dto.DeliveryDto;
import com.training.shop.dto.request.DeliveryRequest;
import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.model.Cart;
import com.training.shop.model.Delivery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Shopping cart")
@RequestMapping(Urls.Cart.FULL)
public interface CartController {

    @Operation(summary = "Get cart content", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderInfoController.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(Urls.Cart.GetList.Id.FULL)
    ResponseEntity<Cart> getById(@Parameter(
            name = "id",
            description = "id  of the cart to be obtained. Cannot be null",
            required = true)
                                 @PathVariable("id") Long id);

    @Operation(summary = "Add item in cart", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderInfoController.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping(Urls.Cart.Create.FULL)
    ResponseEntity<Cart> addInCart(
            @Parameter(
                    description = "the item to add. Cannot be null.",
                    required = true,
                    schema = @Schema(implementation = DeliveryRequest.class))
            @RequestParam("cartId") Long cartId, @RequestBody CartLineDto cartLineDTO);

    @Operation(summary = "Delete item form cart", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderInfoController.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @DeleteMapping(Urls.Cart.Delete.Id.FULL)
    ResponseEntity<String> deleteFromCart(@Parameter(
            name = "id",
            description = "id  of the item in cart to be deleted. Cannot be null",
            required = true)
                                          @PathVariable("id") Long id, @RequestParam("itemId") Long itemId);

    @Operation(summary = "Confirm cart content and form delivery", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OrderInfoController.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping(Urls.Delivery.FULL)
    ResponseEntity<Delivery> formDelivery(@Parameter(
            description = "The delivery to add. Cannot be null.",
            required = true,
            schema = @Schema(implementation = DeliveryRequest.class))
                                                  @RequestParam Long id, @RequestBody DeliveryDto deliveryDto);


}
