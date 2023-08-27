package com.example.delivEatAPI.domain.delivery;

import java.util.UUID;

public interface DeliveryService {
    void startDelivery(DeliveryDto deliveryDto);

    void endDelivery(UUID delivery_id);

    DeliveryDto getDelivery(UUID delivery_id);
}
