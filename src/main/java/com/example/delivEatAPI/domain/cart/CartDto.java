package com.example.delivEatAPI.domain.cart;

import com.example.delivEatAPI.domain.menu.Menu;
import com.example.delivEatAPI.domain.order.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

    private Long cartId;

    private Order order;

    private Menu menu;

    private int quantity;
}
