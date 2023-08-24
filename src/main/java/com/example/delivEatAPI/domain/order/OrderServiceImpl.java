package com.example.delivEatAPI.domain.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public void addOrder(UUID userId, OrderDto orderDto) {

        if(userId.equals(orderDto.getUser().getUserId())){
            Order newOrder = orderMapper.toEntity(orderDto);
            orderRepository.save(newOrder);
        }else {
            throw new IllegalArgumentException("사용자 ID와 주문 정보의 사용자 ID가 일치하지 않습니다.");
        }
    }

    @Override
    @Transactional
    public OrderDto getOrder(UUID order_id) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 주문은 존재하지 않습니다. 주문 ID: " + order_id));

        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public List<OrderDto> getOrderList(UUID userId) {
        try {
            List<Order> orderList = orderRepository.findByUser_UserId(userId);
            return orderMapper.toDtoList(orderList);
        }catch (DataAccessException e){
            throw new RuntimeException("주문목록을 가져올 수 없습니다.", e);
        }
    }

    @Override
    @Transactional
    public void changeStatus(UUID order_id, String status) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 주문은 존재하지 않습니다. 주문 ID: " + order_id));

        order.changeStatus(status);
        orderRepository.save(order);
    }
}
