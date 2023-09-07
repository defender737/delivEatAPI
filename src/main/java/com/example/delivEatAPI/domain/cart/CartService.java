package com.example.delivEatAPI.domain.cart;

import java.util.UUID;

public interface CartService {
    void addCart(CartDto cartDto);

    void changeQuantity(Long cart_id, int quentity);

    void deleteCart(Long cart_id);

}
