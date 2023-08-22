package com.example.delivEatAPI.domain.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public void addOrder(Long userId, OrderDto orderDto) {

        if(userId.equals(orderDto.getUserId())){
            Order newOrder = orderMapper.toEnttiy(orderDto);
            //userId를 찾아서 User를 엔티티에 넣어줘야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            orderRepository.save(newOrder);
        }else {
            throw new IllegalArgumentException("사용자 ID와 주문 정보의 사용자 ID가 일치하지 않습니다.");
        }
    }

    @Override
    public OrderDto getOrder(Long order_id) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 주문은 존재하지 않습니다. 주문 ID: " + order_id));

        OrderDto orderDto = orderMapper.toDto(order);
        orderDto.setUserId(order.getUser().getUserId());
        return orderDto;
    }

    @Override
    public List<OrderDto> getOrderList(Long userId) {
        try {
            List<Order> orderList = orderRepository.findByUser_UserId(userId);
            //LIST는 id를 하나하나 다 넣어줄 수 없는데... Dto를 수정해야하나....................
            return orderMapper.toDtoList(orderList);
        }catch (DataAccessException e){
            throw new RuntimeException("주문목록을 가져올 수 없습니다.", e);
        }
    }

    @Override
    public void changeStatus(Long order_id, String status) {
        Order order = orderRepository.findById(order_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 주문은 존재하지 않습니다. 주문 ID: " + order_id));

        order.changeStatus(status);
        if(!status.equals(order.getStatus())){
            throw new IllegalArgumentException("주문 상태 변경에 실패하였습니다.");
        }
    }
}
