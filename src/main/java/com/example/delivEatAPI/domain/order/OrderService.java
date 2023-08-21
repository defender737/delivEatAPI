package com.example.delivEatAPI.domain.order;

import java.util.List;


public interface OrderService {
   OrderDto getOrder(Long order_id);

   List<OrderDto> getOrderList(Long user_id);

    OrderDto addOrder(Long user_id);

    OrderDto changeStatus(Long order_id, String status);
}
