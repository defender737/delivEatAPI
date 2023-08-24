package com.example.delivEatAPI.domain.cart;

import com.example.delivEatAPI.domain.order.Order;
import com.example.delivEatAPI.domain.order.OrderMapper;
import com.example.delivEatAPI.domain.order.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final OrderRepository orderRepository;


    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public void addCart(UUID orderId, CartDto cartDto) {

        if (orderId.equals(cartDto.getOrder().getOrderId())) {
            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
            order.addCart(cartMapper.toEntity(cartDto));
            orderRepository.save(order);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "OrderId가 일치하지 않습니다.");
        }
    }

    @Override
    public void changeQuantity(UUID orderId, Long cartId, int quantity) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        Cart cartToChange = order.getCartList().stream()
                .filter(cart -> cart.getCartId().equals(cartId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        cartToChange.changeQuantity(quantity);
        cartRepository.save(cartToChange);
    }

    @Override
    public void deleteCart(UUID orderId, Long cartId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        // order의 cartList에 cartId를 가진 Cart가 있다면
        Cart cartToDelete = order.getCartList().stream()
                .filter(cart -> cart.getCartId().equals(cartId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        order.deleteCart(cartToDelete);
        orderRepository.save(order);
        cartRepository.deleteById(cartId);
    }
}
