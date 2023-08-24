package com.example.delivEatAPI.domain.order;


import java.util.List;
import java.util.UUID;


public interface OrderService {

    void addOrder(UUID user_id, OrderDto orderDto);

    OrderDto getOrder(UUID order_id);

    List<OrderDto> getOrderList(UUID user_id);

    void changeStatus(UUID order_id, String status);
}
