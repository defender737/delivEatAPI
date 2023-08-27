package com.example.delivEatAPI.domain.delivery;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/delivery")
public class DeliveryController {

   private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity<String> startDelivery(@RequestBody DeliveryDto deliveryDto) {
        deliveryService.startDelivery(deliveryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("배달이 시작되었습니다.");
    }

    @GetMapping("{delivery_id}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable UUID delivery_id) {
        DeliveryDto deliveryDto = deliveryService.getDelivery(delivery_id);
        return ResponseEntity.ok(deliveryDto);
    }

    @PutMapping("{delivery_id}")
    public ResponseEntity<String> endDelivery(@PathVariable UUID delivery_id) {
        deliveryService.endDelivery(delivery_id);
        return ResponseEntity.status(HttpStatus.CREATED).body("배달이 완료되었습니다.");
    }

}
