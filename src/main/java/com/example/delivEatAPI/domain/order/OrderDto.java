package com.example.delivEatAPI.domain.order;

import com.example.delivEatAPI.domain.cart.Cart;
import com.example.delivEatAPI.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDto {

    public UUID orderId;

    public String status;

    public String address;

    public LocalDateTime datetime;

    public User user;

    private List<Cart> cartList;
}
