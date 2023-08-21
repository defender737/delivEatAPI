package com.example.delivEatAPI.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicempl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServicempl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderDto getOrder(Long order_id) {
        return null;
    }

    @Override
    public List<OrderDto> getOrderList(Long user_id) {
        return null;
    }

    @Override
    public OrderDto addOrder(Long user_id) {
        return null;
    }

    @Override
    public OrderDto changeStatus(Long order_id, String status) {
        return null;
    }
}
