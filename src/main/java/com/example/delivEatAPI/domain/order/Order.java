package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.domain.shop.Shop;
import com.example.delivEatAPI.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId", nullable = false) // Primary Key
    private Long orderId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "datetime", nullable = false)
    private int datetime;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    public Order(String address, int datetime, String status, User user) {
        this.address = address;
        this.datetime = datetime;
        this.status = status;
        this.user = user;
    }
}
