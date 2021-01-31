package com.training.shop.controller.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "core",
url = "${coreTrackingAPIUrl}")
public interface ParcelInfoClient {
}
