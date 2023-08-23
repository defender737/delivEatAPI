package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.domain.cart.Cart;
import com.example.delivEatAPI.domain.shop.Shop;
import com.example.delivEatAPI.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime datetime;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order")
    private final List<Cart> cartList = new ArrayList<>();

    public Order(String address, LocalDateTime datetime, String status, User user) {
        this.address = address;
        this.datetime = datetime;
        this.status = status;
        this.user = user;
    }

    public void changeStatus(String status){this.status = status;}
    public void addCart(Cart cart){cartList.add(cart);}
    public void deleteCart(Cart cart){cartList.remove(cart);}

    @PrePersist
    protected void onCreate() {
        datetime = LocalDateTime.now();
    }
}
