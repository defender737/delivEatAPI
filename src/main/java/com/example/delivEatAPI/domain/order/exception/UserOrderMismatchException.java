package com.example.delivEatAPI.domain.order.exception;

import com.example.delivEatAPI.error.BusinessException;
import com.example.delivEatAPI.error.ErrorCode;

import java.util.UUID;

public class UserOrderMismatchException extends BusinessException {
    public UserOrderMismatchException(UUID orderId){
        super(ErrorCode.MENU_ORDER_MISMATCHED, "사용자와 주문정보가 일치하지 않습니다. orderId:" + orderId);
    }
}
