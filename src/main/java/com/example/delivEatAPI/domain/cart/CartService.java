package com.example.delivEatAPI.domain.cart;

import java.util.UUID;

public interface CartService {
    void addCart(UUID order_id, CartDto cartDto);

    void changeQuantity(UUID order_id, Long cart_id, int quentity);

    void deleteCart(UUID order_id, Long cart_id);

}
