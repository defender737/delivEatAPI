package com.example.delivEatAPI.domain.cart.exception;

import com.example.delivEatAPI.error.BusinessException;
import com.example.delivEatAPI.error.ErrorCode;

public class CartOrderMismatchException extends BusinessException {

    public CartOrderMismatchException(Long cartId){
        super(ErrorCode.CART_ORDER_MISMATCHED, "요청된 주문정보와 일치하지 않습니다. cartId: " +cartId);
    }
}
