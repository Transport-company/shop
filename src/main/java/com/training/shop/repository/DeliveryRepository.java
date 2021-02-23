package com.training.shop.repository;

import com.training.shop.dto.response.DeliveryResponse;
import com.training.shop.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryResponse, Long> {
}