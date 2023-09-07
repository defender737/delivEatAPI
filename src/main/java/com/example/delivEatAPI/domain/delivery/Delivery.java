package com.example.delivEatAPI.domain.delivery;

import com.example.delivEatAPI.domain.order.Order;
import com.example.delivEatAPI.global.config.DateTimeProvider;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "delivery")
public class Delivery {

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "riderName", nullable = false)
    private String riderName;

    @Column(name = "pickupTime", nullable = false)
    private LocalDateTime pickupTime;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(name = "order", nullable = false)
    private Order order;

    @Builder
    public Delivery(String riderName, LocalDateTime pickupTime, Order order) {
        this.id = UUID.randomUUID();
        this.riderName = riderName;
        this.pickupTime = pickupTime;
        this.status = order.getStatus();
        this.order = order;
    }
    @PrePersist
    protected void presetPickupTime() {
        pickupTime = DateTimeProvider.getCurrentDateTime();
    }
}
