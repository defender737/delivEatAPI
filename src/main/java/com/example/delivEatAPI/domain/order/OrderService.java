package com.example.delivEatAPI.domain.order;


import java.util.List;


public interface OrderService {

    void addOrder(Long user_id, OrderDto orderDto);

    OrderDto getOrder(Long order_id);

    List<OrderDto> getOrderList(Long user_id);

    void changeStatus(Long order_id, String status);
}
