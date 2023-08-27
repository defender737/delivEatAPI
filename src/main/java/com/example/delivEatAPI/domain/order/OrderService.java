package com.example.delivEatAPI.domain.order;


import com.example.delivEatAPI.domain.cart.CartDto;

import java.util.List;
import java.util.UUID;


public interface OrderService {

    void addOrder(UUID user_id, OrderDto orderDto);

    OrderDto getOrder(UUID order_id);

    List<OrderDto> getOrderList(UUID user_id);

    void changeStatus(UUID order_id, String status);

    void addCartToOrder(UUID order_id, CartDto cartDto);
}
