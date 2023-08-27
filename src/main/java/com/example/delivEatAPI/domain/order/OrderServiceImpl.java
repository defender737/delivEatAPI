package com.example.delivEatAPI.domain.order;


import com.example.delivEatAPI.domain.cart.CartDto;
import com.example.delivEatAPI.domain.cart.CartMapper;
import com.example.delivEatAPI.domain.order.exception.UserOrderMismatchException;
import com.example.delivEatAPI.error.commonException.EntityNotFoundException;
import com.example.delivEatAPI.error.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CartMapper cartMapper;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CartMapper cartMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.cartMapper = cartMapper;
    }

    @Override
    @Transactional
    public void addOrder(UUID userId, OrderDto orderDto) {

        if(userId.equals(orderDto.getUser().getId())){
            Order newOrder = orderMapper.toEntity(orderDto);
            orderRepository.save(newOrder);
        }else {
            throw new UserOrderMismatchException(orderDto.getId());
        }
    }

    @Override
    @Transactional
    public OrderDto getOrder(UUID order_id) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ORDER_NOT_FOUND, "해당 주문을 찾을 수 없습니다."));
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public List<OrderDto> getOrderList(UUID userId) {
        try {
            List<Order> orderList = orderRepository.findByUser_id(userId);
            return orderMapper.toDtoList(orderList);
        }catch (DataAccessException e){
            throw new EntityNotFoundException(ErrorCode.ORDER_NOT_FOUND, "해당 주문을 찾을 수 없습니다.");
        }
    }

    @Override
    public void addCartToOrder(UUID order_id, CartDto cartDto) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ORDER_NOT_FOUND, "해당 주문을 찾을 수 없습니다."));
        order.addCart(cartMapper.toEntity(cartDto));
        orderRepository.save(order);
    }
    @Override
    @Transactional
    public void changeStatus(UUID order_id, String status) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ORDER_NOT_FOUND, "해당 주문을 찾을 수 없습니다."));
        order.changeStatus(status);
        orderRepository.save(order);
    }
}
