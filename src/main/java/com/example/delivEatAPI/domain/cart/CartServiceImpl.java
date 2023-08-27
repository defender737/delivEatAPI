package com.example.delivEatAPI.domain.cart;


import com.example.delivEatAPI.domain.order.Order;
import com.example.delivEatAPI.domain.order.OrderRepository;
import com.example.delivEatAPI.error.commonException.EntityNotFoundException;
import com.example.delivEatAPI.error.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;


    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public void addCart(CartDto cartDto) {
        Cart cart = cartMapper.toEntity(cartDto);
        cartRepository.save(cart);
    }

    @Override
    public void changeQuantity(Long cartId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.CART_NOT_FOUND, "해당 상품은 존재하지 않습니다."));
        cart.changeQuantity(quantity);
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.CART_NOT_FOUND, "해당 상품은 존재하지 않습니다."));
        cartRepository.delete(cart);
    }
}
