package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Delivery {

        @Id
        @Column(name = "deliveryId",  columnDefinition = "BINARY(16)")
        private UUID deliveryId;

        @Column(name = "riderName", nullable = false)
        private String riderName;

        @Column(name = "pickupTime", nullable = false)
        private LocalDateTime pickupTime;

        @Column(name = "status", nullable = false)
        private String status;

        @OneToOne
        @JoinColumn(name = "order", nullable = false)
        private Order order;

    public Delivery(String riderName, LocalDateTime pickupTime, Order order) {
        this.deliveryId = UUID.randomUUID();
        this.riderName = riderName;
        this.pickupTime = pickupTime;
        this.status = order.getStatus();
        this.order = order;
    }
}
