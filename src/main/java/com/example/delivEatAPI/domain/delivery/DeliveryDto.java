package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryDto {

    private UUID deliveryId;

    private String riderName;

    private LocalDateTime pickupTime;

    private String status;

    private Order order;
}
