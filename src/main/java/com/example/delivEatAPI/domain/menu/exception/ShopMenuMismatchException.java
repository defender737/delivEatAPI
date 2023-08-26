package com.example.delivEatAPI.domain.menu.exception;

import com.example.delivEatAPI.error.BusinessException;
import com.example.delivEatAPI.error.ErrorCode;

public class ShopMenuMismatchException extends BusinessException {

    public ShopMenuMismatchException(Long menuId){
        super(ErrorCode.SHOP_MENU_MISMATCHED, "사용자와 주문정보가 일치하지 않습니다. menuId: " + menuId);
    }
}
