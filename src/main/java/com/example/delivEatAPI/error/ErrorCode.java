package com.example.delivEatAPI.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "COMMON-001", "유효성 검증에 실패"),
    INTERNAL_SERVER_ERROR(500, "COMMON-002", "서버에서 처리 불가"),
    //user
    USER_NOT_FOUND(404, "USER-001", "사용자를 찾을 수 없음"),
    //shop
    SHOP_NOT_FOUND(404, "SHOP-001", "상점을 찾을 수 없음"),
    //menu
    MENU_NOT_FOUND(404, "MENU-001", "메뉴를 찾을 수 없음"),
    SHOP_MENU_MISMATCHED(400, "MENU-001", "상점이 가진 메뉴ID와 일치하지 않음"),
    //order
    ORDER_NOT_FOUND(404, "ORDER-001", "주문을 찾을 수 없음"),
    MENU_ORDER_MISMATCHED(400, "ORDER-002", "사용자가 가진 주문ID와 일치하지 않음"),
    //cart
    CART_NOT_FOUND(404, "CART-001", "주문내 카트가 비어있음"),
    CART_ORDER_MISMATCHED(400, "ORDER-002", "사용자가 가진 주문ID와 일치하지 않음"),
    //delivery
    DELIVERY_NOT_FOUND(404, "DELIVERY-001", "배달 정보를 찾을 수 없음");

    private final int status;
    private final String code;
    private final String description;

    ErrorCode(int status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }
}
