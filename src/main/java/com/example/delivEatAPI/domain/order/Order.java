package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.domain.cart.Cart;
import com.example.delivEatAPI.domain.user.User;
import com.example.delivEatAPI.global.config.DateTimeProvider;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id

    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order")
    private final List<Cart> cartList = new ArrayList<>();

    @Builder
    public Order(String address,LocalDateTime datetime, User user) {
        this.id = UUID.randomUUID();
        this.address = address;
        this.datetime = datetime;
        this.status = "접수중";
        this.user = user;
    }

    public void changeStatus(String status){this.status = status;}
    public void addCart(Cart cart){cartList.add(cart);}
    public void deleteCart(Cart cart){cartList.remove(cart);}

    @PrePersist
    protected void presetDateTime() {
        datetime = DateTimeProvider.getCurrentDateTime();
    }
}
