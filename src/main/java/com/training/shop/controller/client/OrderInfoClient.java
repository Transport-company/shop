package com.training.shop.controller.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "core",
        url = "${core.trackingAPI.url}")
public interface OrderInfoClient {
}
