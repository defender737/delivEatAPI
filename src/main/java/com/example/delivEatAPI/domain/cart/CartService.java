package com.example.delivEatAPI.domain.cart;

public interface CartService {
    void addCart(Long order_id, CartDto cartDto);

    void deleteCart(Long order_id, Long cart_id);
}
